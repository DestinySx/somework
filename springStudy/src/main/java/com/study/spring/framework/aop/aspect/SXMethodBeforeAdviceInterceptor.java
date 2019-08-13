package com.study.spring.framework.aop.aspect;

import com.study.spring.framework.aop.intercept.SXMethodInterceptor;
import com.study.spring.framework.aop.intercept.SXMethodInvocation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:47
 * Description:
 **/
public class SXMethodBeforeAdviceInterceptor extends SXAbstractAspectAdvice implements SXAdvice,SXMethodInterceptor {

    private SXJoinPoint joinPoint;

    public SXMethodBeforeAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    private void before(Method method,Object[] args,Object target) throws Throwable{
        //传送了给织入参数
        //method.invoke(target);
        super.invokeAdviceMethod(this.joinPoint,null,null);

    }

    @Override
    public Object invoke(SXMethodInvocation invocation) throws Throwable {
        //从被织入的代码中才能拿到，JoinPoint
        this.joinPoint = invocation;
        before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return invocation.proceed();
    }
}