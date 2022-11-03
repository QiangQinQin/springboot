package com.tulun.pojo;

/**
 * @author QiangQin
 * * @date 2021/8/11
 */
public class Student {
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

    @Override
    public String toString() {
        return "Student{" +
                "SID=" + SID +
                ", Sname='" + Sname + '\'' +
                '}';
    }
}
