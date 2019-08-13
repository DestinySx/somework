package com.study.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:40
 * Description:
 **/
public interface SXJoinPoint {
    Object getThis();

    Object[] getArguments();

    Method getMethod();

    void setUserAttribute(String key, Object value);

    Object getUserAttribute(String key);
}