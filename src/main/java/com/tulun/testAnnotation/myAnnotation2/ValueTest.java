package com.tulun.testAnnotation.myAnnotation2;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * description: 针对 com.haha.study.annotation.value.User 类使用注解的测试
 *
 * @author w
 * @version v1.0
 * @date 2018 年 8 月 1 日下午 2:37:13
 */

public class ValueTest {
    public static void main(String[] args) throws Exception {
        User user = new User();
        // 1、 获取 User 类上的注解 @ConsAnnotation
        ConsAnnotation anno = user.getClass().getAnnotation(ConsAnnotation.class);
        // 获取 @ConsAnnotation注解配置的 值
        String[] arr = anno.request();
        System.out.println(Arrays.toString(arr)); // [hello, world, annotation!]

// 2、 获取 User 类中 private String userName; 变量上的注解 @Field
        Field f = user.getClass().getDeclaredField("userName");
        Fields anno2 = f.getAnnotation(Fields.class);
        user.setUserName(anno2.value());
        System.out.println(user.getUserName()); // 中华人民共和国
    }
}
