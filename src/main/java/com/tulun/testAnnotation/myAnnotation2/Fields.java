package com.tulun.testAnnotation.myAnnotation2;

import java.lang.annotation.*;

/**
* description: 定义一个注解，用于给 全局变量 field 字段 赋值，并使用反射取值。 <br>
* 特别提醒： @Rentention (RetentionPolicy.RUNTIME) 时，注解才会被 jvm 加载，才能使用反射获取。
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value= ElementType.FIELD)
public @interface Fields {
int sort() default 0 ;
String value() ;
}
