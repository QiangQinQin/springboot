package com.tulun.testRestTemplate;

import com.tulun.pojo.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author QiangQin
 * * @date 2022/12/11
 *
教程： https://zhuanlan.zhihu.com/p/127082567
 */
public class testGetParam {

//    localhost:8080/demo1?name=Aaron&age=18
    @RequestMapping(value="/demo1")
    public void testRequestParam(@RequestParam String name, @RequestParam int age ){
        System.out.println("get name is : " + name + ", age: " + age); //   get name is : Aaron, age: 18
        return;
    }
////形参列表将会过长导致可读性降低。可以直接使用一个POJO对象来进行绑定接收，
//@RequestMapping(value="/demo11")
//public void  testRequestParam(Student student){
//    System.out.println("get name is : " + name + ", age: " + age);
//    return;
//}


/*
localhost:8080/demo2/Bob/12
 */
    @RequestMapping(value="/demo2")
//    @PathParam 注解 也是用于从绑定URL中占位符的参数，只不过其是JBoss下的实现
    public void testPathVariable (@PathVariable String name, @PathVariable int id) {
        System.out.println("get name is : " + name + ", id: " + id); //      get name is : Bob, id: 12
        return;
    }
}
