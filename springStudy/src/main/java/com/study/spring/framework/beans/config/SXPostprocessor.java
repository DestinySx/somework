package com.study.spring.framework.beans.config;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 12:48
 * Description:
 **/
public class SXPostprocessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}