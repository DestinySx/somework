package com.study.spring.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/11   Time: 19:07
 * Description:
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SXRequestParam {
    String value() default "";

    String name() default "";

    boolean required() default true;

    String defaultValue() default "\n\t\t\n\t\t\n\uE000\uE001\uE002\n\t\t\t\t\n";
}