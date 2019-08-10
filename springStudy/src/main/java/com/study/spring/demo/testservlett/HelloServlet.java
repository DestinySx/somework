package com.study.spring.demo.testservlett;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 18:15
 * Description:
 **/
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理Get请求。。。。。");
        PrintWriter out = resp.getWriter();
        out.println("Hello Servlet-Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理Post请求。。。。。");
        PrintWriter out = resp.getWriter();
        out.println("Hello Servlet-Post");
    }
}