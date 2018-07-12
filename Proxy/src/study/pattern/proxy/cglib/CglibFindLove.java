package study.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibFindLove implements MethodInterceptor {
    public Object getInstance(Class<?> clazz) throws  Exception{
        Enhancer enhancer = new Enhancer();
        //要把哪个设置为即将生成的新类父类
        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return  enhancer.create();

    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
        //业务的增强

        System.out.println("开始找对象：");

        methodProxy.invokeSuper(o,objects);

        System.out.println("找对象结束。");
        return null;
    }
}
