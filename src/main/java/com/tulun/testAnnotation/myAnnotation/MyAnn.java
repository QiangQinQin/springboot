package com.tulun.testAnnotation.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qiangqin
 */
@Target({ElementType.METHOD}) // 标记这个注解可以用于哪些地方
@Retention(RetentionPolicy.RUNTIME) // 表示自定义注解的生命周期
public @interface MyAnn {
    String value() default "d";
}