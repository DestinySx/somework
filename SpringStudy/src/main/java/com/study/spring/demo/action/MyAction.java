package com.study.spring.demo.action;

import com.study.spring.demo.service.IMyService;
import com.study.spring.framework.annotation.SXAutowired;
import com.study.spring.framework.annotation.SXController;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 18:07
 * Description:
 **/
@SXController
public class MyAction {

    @SXAutowired
    IMyService myService;
}