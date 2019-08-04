package study.pattern.proxy.custom;

import study.pattern.proxy.jdk.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/4   Time: 13:07
 * Description:
 **/
public class SFindLove extends SInvocationHandler {

    private Person person;

    public Object getInstance(Person perpson) throws Exception{
        this.person = perpson;

        Class<?> clazz = perpson.getClass();

        return SProxy.newProxyInstance(new SClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始找工作：");
        method.invoke(this.person,args);
        System.out.println("找工作结束！");
        return  null;
    }
}