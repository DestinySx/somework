package com.study.spring.framework.context;

import com.study.spring.framework.annotation.SXAutowired;
import com.study.spring.framework.annotation.SXController;
import com.study.spring.framework.annotation.SXService;
import com.study.spring.framework.aop.SXAopProxy;
import com.study.spring.framework.aop.SXCglibAopProxy;
import com.study.spring.framework.aop.SXJdkDynamicAopProxy;
import com.study.spring.framework.aop.config.SXAopConfig;
import com.study.spring.framework.aop.support.SXAdvisedSupport;
import com.study.spring.framework.beans.SXBeanWrapper;
import com.study.spring.framework.beans.SXBeanFactory;
import com.study.spring.framework.beans.config.SXBeanDefinition;
import com.study.spring.framework.beans.config.SXPostprocessor;
import com.study.spring.framework.beans.support.SXBeanDefinitionReader;
import com.study.spring.framework.beans.support.SXDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 18:42
 * Description:
 **/
public class SXApplicationContext extends SXDefaultListableBeanFactory implements SXBeanFactory {

    private String[] configLocation;

    private SXBeanDefinitionReader sxBeanDefinitionReader;

    // 单例的IOC容器缓存
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();

    // 通用的IOC容器
    private Map<String,SXBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    public SXApplicationContext(String... configLocation){
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    protected void refresh() {

        // 1 定位配置文件
        sxBeanDefinitionReader = new SXBeanDefinitionReader(this.configLocation);

        // 2 加载配置文件，扫描相关的类，封装成beanDefinition
        List<SXBeanDefinition> beanDefinition =  sxBeanDefinitionReader.loadBeanDefinitions();

        // 3 注册，把配置信息放到容器里面（伪IOC容器）
        doRegisterBeanDefinition(beanDefinition);

        // 4 不是延时加载的类要提前初始化
        doAutowrited();
    }

    //只处理非延时加载的类
    private void doAutowrited() {
        for (Map.Entry<String, SXBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            if(!beanDefinitionEntry.getValue().isLazyInit()){
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doRegisterBeanDefinition(List<SXBeanDefinition> beanDefinitions) {
        for (SXBeanDefinition beanDefinition:beanDefinitions) {
            this.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
        }

    }

    @Override
    public Object getBean(Class<?> clazz) throws Exception {
       return getBean(clazz.getSimpleName());
    }

    @Override
    public Object getBean(String beanName) throws Exception {

        // 1 初始化
        Object instantce = instantiateBean(beanName,this.beanDefinitionMap.get(beanName));
        //把对象封装到beanwrapp
        SXBeanWrapper beanWrapper = new SXBeanWrapper(instantce);


        SXPostprocessor sxPostprocessor = new SXPostprocessor();
        //前置通知
        sxPostprocessor.postProcessBeforeInitialization(instantce,beanName);

        //2 把beanWrapper保存到IOC容器中
//        if(this.factoryBeanInstanceCache.containsKey(beanName)){
//            throw new Exception("The"+beanName+"is exist!");
//        }
        this.factoryBeanInstanceCache.put(beanName,beanWrapper);

        //后置通知
        sxPostprocessor.postProcessAfterInitialization(instantce,beanName);

        //3 注入
        populateBean(beanName,new SXBeanDefinition(),beanWrapper);

        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }


    private Object instantiateBean(String beanName, SXBeanDefinition sxBeanDefinition) {

        //1 拿到要实例化的类名
        String className = sxBeanDefinition.getBeanClassName();

        //2 反射实例化，得到一个对象
        Object instance = null;
        try{
            if(singletonObjects.containsKey(className)){
                instance = singletonObjects.get(className);
            }else{
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();

                SXAdvisedSupport config = instantionAopConfig(sxBeanDefinition);
                config.setTargetClass(clazz);
                config.setTarget(instance);
                //符合PointCut的规则的话，闯将代理对象
                if(config.pointCutMatch()) {
                    instance = createProxy(config).getProxy();
                }

                singletonObjects.put(className,instance);
                singletonObjects.put(sxBeanDefinition.getFactoryBeanName(),instance);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    private void populateBean(String beanName, SXBeanDefinition sxBeanDefinition, SXBeanWrapper sxBeanWrapper) {
        Object instance = sxBeanWrapper.getWrappedInstance();

        Class<?> clazz = sxBeanWrapper.getWrappedClass();

        if (!(clazz.isAnnotationPresent(SXController.class) || clazz.isAnnotationPresent(SXService.class))) {
            return;
        }

        Field[] fields = clazz.getFields();
        for(Field field:fields){
            if(!field.isAnnotationPresent(SXAutowired.class)){continue;}

            SXAutowired autowired = field.getAnnotation(SXAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }

            //强制访问
            field.setAccessible(true);

            try {
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    private SXAopProxy createProxy(SXAdvisedSupport config) {

        Class targetClass = config.getTargetClass();
        if(targetClass.getInterfaces().length > 0){
            return new SXJdkDynamicAopProxy(config);
        }
        return new SXCglibAopProxy(config);
    }

    private SXAdvisedSupport instantionAopConfig(SXBeanDefinition gpBeanDefinition) {
        SXAopConfig config = new SXAopConfig();
        config.setPointCut(this.sxBeanDefinitionReader.getConfig().getProperty("pointCut"));
        config.setAspectClass(this.sxBeanDefinitionReader.getConfig().getProperty("aspectClass"));
        config.setAspectBefore(this.sxBeanDefinitionReader.getConfig().getProperty("aspectBefore"));
        config.setAspectAfter(this.sxBeanDefinitionReader.getConfig().getProperty("aspectAfter"));
        config.setAspectAfterThrow(this.sxBeanDefinitionReader.getConfig().getProperty("aspectAfterThrow"));
        config.setAspectAfterThrowingName(this.sxBeanDefinitionReader.getConfig().getProperty("aspectAfterThrowingName"));
        return new SXAdvisedSupport(config);
    }

    public Properties getConfig(){
        return this.sxBeanDefinitionReader.getConfig();
    }

    public String[] getBeanDefinitionNames(){
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount(){
        return this.beanDefinitionMap.size();
    }

}