
package com.tulun.testAnnotation.myAnnotation2;
/**
 * description: 创建一个普通的类，使用 @ConsAnnotation、@Fields 注解。
 *
 * @author w
 * @version v1.0
 * @date 2018 年 8 月 1 日下午 2:50:23
 */
@ConsAnnotation(request = {"hello", "world", "annotation!"})
public class User {
    @Fields("中华人民共和国")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}