package com.tulun;

import com.tulun.pojo.Student;
import com.tulun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2021/8/8
 */
@Controller
public class HelloController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    @ResponseBody  //即返回一个json对象
    public List<Student> list() {
        return studentService.findAll();
    }
//    Object

// URL: http://localhost:8080/hello
    @RequestMapping("/hello")
    @ResponseBody  //即返回一个json对象
    public String hello() {
        return "Hello Tulun";
    }
//    Object

//    http://localhost:8080/findById/1
    @GetMapping("/findById/{id}")
    @ResponseBody
    public Student findById(@PathVariable("id")Integer id){
        return studentService.getStudentBySid(id);
    }
}