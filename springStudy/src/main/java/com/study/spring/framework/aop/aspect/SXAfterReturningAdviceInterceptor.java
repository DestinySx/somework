package com.study.spring.framework.aop.aspect;

import com.study.spring.framework.aop.intercept.SXMethodInterceptor;
import com.study.spring.framework.aop.intercept.SXMethodInvocation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:50
 * Description:
 **/
public class SXAfterReturningAdviceInterceptor extends SXAbstractAspectAdvice implements SXAdvice,SXMethodInterceptor {

    private SXJoinPoint joinPoint;

    public SXAfterReturningAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(SXMethodInvocation invocation) throws Throwable {
        Object retVal = invocation.proceed();
        this.joinPoint = invocation;
        this.afterReturning(retVal,invocation.getMethod(),invocation.getArguments(),invocation.getThis());
        return retVal;
    }

    private void afterReturning(Object retVal, Method method, Object[] arguments, Object aThis) throws Throwable {
        super.invokeAdviceMethod(this.joinPoint,retVal,null);
    }
}