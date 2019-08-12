package com.study.spring.framework.webmvc.servlet;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 14:51
 * Description:
 **/
public class SXHandlerMapping {

    protected Object controller;//保存方法对应的实例

    protected Method method;//保存映射的方法

    protected Pattern pattern; //url的正则匹配

    public SXHandlerMapping(Pattern pattern,Object controller, Method method) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}