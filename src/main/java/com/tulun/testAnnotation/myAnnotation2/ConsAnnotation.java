package com.tulun.testAnnotation.myAnnotation2;

import java.lang.annotation.*;

/**
* description: 定义一个注解。
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConsAnnotation {
String[] request();
}