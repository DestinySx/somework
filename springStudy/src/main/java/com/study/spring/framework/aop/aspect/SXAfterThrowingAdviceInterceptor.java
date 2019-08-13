package com.study.spring.framework.aop.aspect;

import com.study.spring.framework.aop.intercept.SXMethodInterceptor;
import com.study.spring.framework.aop.intercept.SXMethodInvocation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:51
 * Description:
 **/
public class SXAfterThrowingAdviceInterceptor extends SXAbstractAspectAdvice implements SXAdvice,SXMethodInterceptor {


    private String throwingName;

    public SXAfterThrowingAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(SXMethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        }catch (Throwable e){
            invokeAdviceMethod(invocation,null,e.getCause());
            throw e;
        }
    }

    public void setThrowName(String throwName){
        this.throwingName = throwName;
    }
}