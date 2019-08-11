package com.study.spring.framework.beans.support;

import com.study.spring.framework.beans.config.SXBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 20:17
 * Description:
 **/
public class SXBeanDefinitionReader {


    private List<String> registyBeanClasses = new ArrayList<>();

    private Properties config = new Properties();

    //固定 配置文件中的key，相当于xml中的规范
    private final String SCAN_PACKAGE = "scanPackage";

    public SXBeanDefinitionReader(String... location){
        //通过URL定位找到其所对应的文件，然后转化为文件流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location[0].replace("classPath:",""));

        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getResource("/"+scanPackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for(File file:classPath.listFiles()){
             if(file.isDirectory()){
                 doScanner(scanPackage+"."+file.getName());
             }else{
                 if(!file.getName().endsWith(".class")){continue;}
                 String className = (scanPackage+"."+file.getName().replace(".class",""));
                 registyBeanClasses.add(className);
             }

        }
    }

    public Properties getConfig(){
        return this.config;
    }

    public List<SXBeanDefinition> loadBeanDefinitions(){

        List<SXBeanDefinition> beanDefinitions = new ArrayList<>();
        try{
            for(String className:registyBeanClasses){

                Class<?> beanClass = Class.forName(className);
                if(beanClass.isInterface()){continue;}
                beanDefinitions.add(doCreateBeanDefinition(beanClass.getSimpleName(),beanClass.getName()));

                Class<?> [] interfaces = beanClass.getInterfaces();
                for(Class i:interfaces){
                    beanDefinitions.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return beanDefinitions;
    }

    //把每一个配置信息解析成 beandefinition
    private SXBeanDefinition doCreateBeanDefinition(String simpleName, String className){
        try{
            SXBeanDefinition beanDefinition = new SXBeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryBeanName(toLowerFirstCase(simpleName));
            return  beanDefinition;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //类名首字母小写
    private String toLowerFirstCase(String simpleName){
        char[] charName = simpleName.toCharArray();
        charName[0] += 32;
        return String.valueOf(charName);
    }
}