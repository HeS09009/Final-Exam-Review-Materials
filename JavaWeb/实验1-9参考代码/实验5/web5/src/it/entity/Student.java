package it.entity;

public class Student {
    private String sno;
    private String sname;
    //【代码1】 带2个参数的构造函数；以及成员变量的getter和setter
    public Student(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
