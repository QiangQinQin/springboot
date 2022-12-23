package com.tulun.pojo;

import java.io.Serializable;

/**
 * @author QiangQin
 * * @date 2021/8/11
 */

//要缓存的 Java 对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入 Redis
public class Student  implements Serializable {
    private  Integer SID;
    private  String  Sname;

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Student(Integer sid, String sname){
        this.SID=sid;
        this.Sname=sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SID=" + SID +
                ", Sname='" + Sname + '\'' +
                '}';
    }
}
