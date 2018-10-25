package study.pattern.proxy.rewrite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/10/25   Time: 20:56
 * Description:
 **/
public class Proxy_1 implements InvocationHandler {

    //代理类需要拿到被代理对象的接口
    private Proxy_interfances proxy_interfances;

    public Object getInstance(Proxy_interfances target){
        this.proxy_interfances = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("开始代理");
        method.invoke( this.proxy_interfances,args);
        System.out.printf("代理结束");
        return null;
    }
}