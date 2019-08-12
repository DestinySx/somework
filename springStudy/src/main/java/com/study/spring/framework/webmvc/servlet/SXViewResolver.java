package com.study.spring.framework.webmvc.servlet;

import java.io.File;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 17:20
 * Description:
 **/
public class SXViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFX = ".html";

    private File templateRootDir;

//    private String viewName;

    public SXViewResolver(String templateRoot) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        templateRootDir = new File(templateRootPath);
    }

    public SXView resolverView(String viewName,Locale locale){
        if(null == viewName || "".equals(viewName)){return null;}

        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFX)?viewName:viewName+DEFAULT_TEMPLATE_SUFFX;
        File templateFile = new File((this.templateRootDir.getPath() + "/" + viewName).replaceAll("/+","/"));
        return new SXView(templateFile);
    }

//    public String getViewName() {
//        return viewName;
//    }
}