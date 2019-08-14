package com.study.spring.demo.action;

import com.study.spring.demo.service.IMyService;
import com.study.spring.framework.annotation.SXAutowired;
import com.study.spring.framework.annotation.SXController;
import com.study.spring.framework.annotation.SXRequestMapping;
import com.study.spring.framework.annotation.SXRequestParam;
import com.study.spring.framework.webmvc.servlet.SXModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 18:07
 * Description:
 **/
@SXController
@SXRequestMapping("/myAction")
public class MyAction {

    @SXAutowired
    public IMyService myServiceImpl;

    @SXRequestMapping("/query.json")
    public SXModelAndView query(HttpServletRequest request, HttpServletResponse response,
                                @SXRequestParam("name") String name){
        String result = myServiceImpl.query(name);
        return out(response,result);
    }


    @SXRequestMapping("/add*.json")
    public SXModelAndView add(HttpServletRequest request, HttpServletResponse response, @SXRequestParam("name") String name, @SXRequestParam("addr") String addr) {
        String result = null;
        try {
            result = myServiceImpl.add(name, addr);
            return out(response, result);
        } catch (Exception e) {
//			e.printStackTrace();
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("detail", e.toString());
//			System.out.println(Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]",""));
            model.put("stackTrace", Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]", ""));

            return new SXModelAndView("500", model);
        }
    }

    private SXModelAndView out(HttpServletResponse resp, String str) {
        try {
            resp.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}