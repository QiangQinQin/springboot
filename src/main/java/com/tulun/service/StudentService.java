package com.tulun.service;

import com.tulun.mapper.StudentMapper;
import com.tulun.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2021/8/11
 */
@Service
public class StudentService {
    @Autowired
    private  StudentMapper studentMapper;



    public List<Student>  findAll(){
        return  studentMapper.findAll();
    }

    /*
    需先启动redis: redis-server  redis.windows.conf
    https://www.jianshu.com/p/d9ecd56710c4
value : 必须要的。就是个自己取的名字，通过它指明了第一次调用这个方法时返回的getStudentBySid将被存在内存的哪里。
key ： 可选。要使用SpEL表达式，这里与参数sid对应，当传入的sid值变了的话就不去取缓存里的数据了，而是执行getStudentBySid方法。（这是必须的，因为sid变了，返回值也就变了，缓存里的数据不符合了，因此这个选项很重要）。spring默认用方法的签名来当做key。
condition：方法返回的结果student，要不要缓存起来？condition就添加了一个限定条件。这个例子中，只有传入的sid是1，返回的student才会被缓存起来，如果给sid传了别的值，那么student是不会缓存起来的。

    * */
    @Cacheable(value = "student" ,key = "'sid='+ #sid" )
    public Student getStudentBySid(Integer sid) {
        return new Student(sid,"testName");
    }

    /*
    一个缓存名value  对应一个被注解的方法
    key 的值还是需要根据参数的不同来生成
    https://www.cnblogs.com/coding-one/p/12401630.html
    * */
    @Cacheable(value = "student",key = "'student.sid='+ #sid")
    public Student getStudentBySid(Student student) {
        return new Student(student.getSID(),"testName");
    }
}
