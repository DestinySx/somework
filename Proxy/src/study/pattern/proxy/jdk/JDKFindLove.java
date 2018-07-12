package study.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

public class JDKFindLove implements InvocationHandler{
    private Person person;

    public Object getInstance(Person perpson) throws Exception{
        this.person = perpson;

        Class<?> clazz = perpson.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("开始找对象：");
        method.invoke(this.person,args);
        System.out.println("找对象结束！");
        return  null;
    }
}
