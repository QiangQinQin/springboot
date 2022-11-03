package com.tulun.service;

import com.tulun.mapper.StudentMapper;
import com.tulun.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
