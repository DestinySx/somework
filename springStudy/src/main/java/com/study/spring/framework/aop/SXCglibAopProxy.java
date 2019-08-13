package com.study.spring.framework.aop;

import com.study.spring.framework.aop.support.SXAdvisedSupport;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/13   Time: 12:29
 * Description:
 **/
public class SXCglibAopProxy implements SXAopProxy {

    public SXCglibAopProxy(SXAdvisedSupport config) {
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}