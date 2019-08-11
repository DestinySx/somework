package com.study.spring.framework.beans;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 18:36
 * Description: 单例工厂的顶层设计
 **/
public interface SXBeanFactory {

    /*
    * 1 根据beanName从IOC容器中获取对象
    *
    * */
    Object getBean(String beanName) throws Exception;

    Object getBean(Class<?> clazz) throws Exception;
}