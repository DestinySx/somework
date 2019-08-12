package com.study.spring.framework.webmvc.servlet;

import com.study.spring.framework.annotation.SXController;
import com.study.spring.framework.annotation.SXRequestMapping;
import com.study.spring.framework.context.SXApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 13:02
 * Description:
 **/
public class SXDispatcherServlet extends HttpServlet{


    private final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";

    private SXApplicationContext context;

    private List<SXHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<SXHandlerMapping,SXHandlerAdapter> handlerAdapters = new HashMap<>();

    private List<SXViewResolver> viewResolvers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.doDispatch(req, resp);
        }catch (Exception e){
            //打印异常信息到前台SX
            //processDispatchResult(req,resp,new SXModelAndView("500"));
            resp.getWriter().write("500 Exception, Details:\r\n:"+ Arrays.toString(e.getStackTrace()).replaceAll("\\[\\]","").replaceAll("\\s","\r\n"));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1 通过从request中拿到url，去匹配一个handlerMapping
        SXHandlerMapping handler = getHandler(req);

        if(handler == null){
            processDispatchResult(req,resp,new SXModelAndView("404"));
            return;
        }

        //2 准备调用前的参数
        SXHandlerAdapter handlerAdapter = getandlerAdapter(handler);

        //3 真正的调用方法
        SXModelAndView mv = handlerAdapter.handle(req,resp,handler);

        processDispatchResult(req, resp,  mv);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, SXModelAndView mv) throws Exception {
        //把 SXModelAndView 转换成 html. json,OutputStream
        if(null == mv) return;

        if(this.viewResolvers.isEmpty()) return;

        for(SXViewResolver viewResolver:this.viewResolvers){
            SXView sxView = viewResolver.resolverView(mv.getViewName(),null);
            sxView.render(mv.getModel(),req,resp);
        }

    }

    private SXHandlerAdapter getandlerAdapter(SXHandlerMapping handler) {
        if(this.handlerAdapters.isEmpty()){ return  null;}

        SXHandlerAdapter ha = this.handlerAdapters.get(handler);

        if(ha.supports(handler)){
            return ha;
        }
        return null;
    }

    private SXHandlerMapping getHandler(HttpServletRequest req) throws Exception{
        if(this.handlerMappings.isEmpty()){return  null;}

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();

        url = url.replaceAll(contextPath,"").replaceAll("/+","/");

        for(SXHandlerMapping handler:this.handlerMappings){
            try{
                Matcher matcher = handler.getPattern().matcher(url);
                if(!matcher.matches()){continue;}
                return handler;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1 初始化Application
        context = new SXApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));
        //2 初始化SpringMVC九大组件
        initStrategies(context);
    }

    protected void initStrategies(SXApplicationContext context) {
        //多文件上传组件
        initMultipartResolver(context);
        //初始化本地语言环境
        initLocaleResolver(context);
        //初始化模板处理器
        initThemeResolver(context);


        //初始化handlerMappings
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
        //初始化异常拦截器
        initHandlerExceptionResolvers(context);


        //初始化视图预处理器
        initRequestToViewNameTranslator(context);
        //初始化视图转换器
        initViewResolvers(context);
        //参数缓存器
        initFlashMapManager(context);
    }

    private void initMultipartResolver(SXApplicationContext context) {
    }

    private void initLocaleResolver(SXApplicationContext context) {
    }

    private void initThemeResolver(SXApplicationContext context) {
    }

    private void initHandlerMappings(SXApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        try{
            for(String beanName:beanNames){
                Object controller = context.getBean(beanName);
                Class<?> clazz = controller.getClass();
                if(!clazz.isAnnotationPresent(SXController.class)){ continue;}

                String baseUrl = null;

                //获取controller的url
                if(clazz.isAnnotationPresent(SXRequestMapping.class)){
                    SXRequestMapping requestMapping = clazz.getAnnotation(SXRequestMapping.class);
                    baseUrl = requestMapping.value();
                }

                //获取method的url
                Method[] methods = clazz.getMethods();
                for(Method method:methods){
                    if(!method.isAnnotationPresent(SXRequestMapping.class)){ continue;}

                    SXRequestMapping requestMapping = method.getAnnotation(SXRequestMapping.class);

                    String regex = ("/"+baseUrl+"/"+requestMapping.value().replaceAll("\\*",".*")).replaceAll("/+","/");

                    Pattern pattern = Pattern.compile(regex);
                    this.handlerMappings.add(new SXHandlerMapping(pattern,controller,method));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void initHandlerAdapters(SXApplicationContext context) {
        //把一个request请求变成一个handle,参数都是字符串的

        for(SXHandlerMapping handlerMapping:this.handlerMappings){
            this.handlerAdapters.put(handlerMapping,new SXHandlerAdapter());
        }
    }

    private void initHandlerExceptionResolvers(SXApplicationContext context) {
    }

    private void initRequestToViewNameTranslator(SXApplicationContext context) {
    }

    private void initViewResolvers(SXApplicationContext context) {

        //拿到模板的存放目录
        String templateRoot = context.getConfig().getProperty("templateRoot");

        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(templateRootPath);
        for(File template:templateRootDir.listFiles()){
            this.viewResolvers.add(new SXViewResolver(templateRoot));
        }
    }

    private void initFlashMapManager(SXApplicationContext context) {
    }

}