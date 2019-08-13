package com.study.spring.framework.aop.intercept;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:43
 * Description:
 **/
public interface SXMethodInterceptor {
    Object invoke(SXMethodInvocation invocation) throws Throwable;
}