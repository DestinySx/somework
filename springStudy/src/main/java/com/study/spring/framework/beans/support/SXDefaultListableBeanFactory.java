package com.study.spring.framework.beans.support;

import com.study.spring.framework.beans.config.SXBeanDefinition;
import com.study.spring.framework.context.support.SXAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 18:51
 * Description:
 **/
public class SXDefaultListableBeanFactory extends SXAbstractApplicationContext {

    //存储配置文件信息
    protected final Map<String, SXBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
}