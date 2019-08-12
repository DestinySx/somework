package com.study.spring.framework.webmvc.servlet;

import com.study.spring.framework.annotation.SXRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 15:09
 * Description:
 **/
public class SXHandlerAdapter {

    public boolean supports(Object handler){
        return (handler instanceof SXHandlerMapping);
    }

    public SXModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws InvocationTargetException, IllegalAccessException {
        SXHandlerMapping handlerMapping = (SXHandlerMapping)handler;

        //把方法的形参列表和request的参数列表一一对应
        Map<String,Integer> paramIndexMapping = new HashMap<>();

        //提取方法中加了注解的参数
        //把方法上的注解拿到，得到一个二维数组
        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for(int i=0;i<pa.length;i++){
            for(Annotation a:pa[i]){
                if(a instanceof SXRequestParam){
                    String paramName = ((SXRequestParam) a).value();
                    if(!("".equals(paramName.trim()))){
                        paramIndexMapping.put(paramName,i);
                    }
                }
            }
        }

        //提取方法中的request和response参数
        Class<?>[] paramsTypes = handlerMapping.getMethod().getParameterTypes();
        for(int i=0;i<paramsTypes.length;i++){
            Class<?> type = paramsTypes[i];

            if(type == HttpServletRequest.class || type == HttpServletResponse.class){
                paramIndexMapping.put(type.getName(),i);
            }
        }

        //获取request中的参数
        Map<String,String[]> params = request.getParameterMap();
        //存储实参列表
        Object[] paramValues = new Object[paramsTypes.length];

        for(Map.Entry<String,String[]> param:params.entrySet()){
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]","").replaceAll("\\s",",");

            if(!paramIndexMapping.containsKey(param.getKey())){continue;}

            int index = paramIndexMapping.get(param.getKey());
            paramValues[index] = convert(value,paramsTypes[index]);
        }

        if(paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[index] = request;
        }

        if(paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[index] = response;
        }

        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(),paramValues);
        if(result == null || result instanceof Void) {return null;}

        boolean isModleAndView = handlerMapping.getMethod().getReturnType() == SXModelAndView.class;
        if(isModleAndView){
            return  (SXModelAndView)result;
        }

        return null;
    }

    //参数类型转换
    private Object convert(String value, Class<?> paramsType) {
        if(String.class == paramsType){
            return value;
        }else if(Integer.class == paramsType){
            return Integer.valueOf(value);
        }else if(Double.class == paramsType){
            return Double.valueOf(value);
        }else{
            if(value!=null){
                return  value.toString();
            }
            return null;
        }

    }
}