package com.study.spring.framework.webmvc.servlet;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 15:11
 * Description:
 **/
public class SXModelAndView {

    private String viewName;

    private Map<String,?> model;

    public SXModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public SXModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }
}