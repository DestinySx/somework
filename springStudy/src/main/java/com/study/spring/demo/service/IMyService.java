package com.study.spring.demo.service;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 12:00
 * Description:
 **/
public interface IMyService {

    String query(String name);

    String add(String name,String addr) throws Exception;
}