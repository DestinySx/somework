package com.study.spring.demo.service.impl;

import com.study.spring.demo.service.IMyService;
import com.study.spring.framework.annotation.SXService;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 12:00
 * Description:
 **/
@SXService
@Slf4j
public class MyServiceImpl implements IMyService{


    /**
     * 查询
     */
    @Override
    public String query(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
        log.info("这是在业务方法中打印的：" + json);
        return json;
    }

    @Override
    public String add(String name,String addr) throws Exception {
        throw new Exception("故意抛的异常！！");
        //return "modifyService add,name=" + name + ",addr=" + addr;
    }

}