package com.study.spring.framework.aop;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:28
 * Description:
 **/
public interface SXAopProxy {

    Object getProxy();


    Object getProxy(ClassLoader classLoader);
}