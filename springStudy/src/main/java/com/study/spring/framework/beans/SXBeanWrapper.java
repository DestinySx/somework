package com.study.spring.framework.beans;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/10   Time: 23:33
 * Description:
 **/
public class SXBeanWrapper {

    private Object wrappedInstance;

    private Class<?> wrappdeClass;

    public SXBeanWrapper(Object wrappedInstance){
        this.wrappedInstance = wrappedInstance;
    }

    /**
     * Return the bean instance wrapped by this object.
     */
    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }

    /**
     * Return the type of the wrapped bean instance.
     */
    public Class<?> getWrappedClass(){
        return this.wrappedInstance.getClass();
    }
}