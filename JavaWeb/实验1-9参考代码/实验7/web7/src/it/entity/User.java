package it.entity;

public class User {
    private String sno;
    private String name;
    private Integer age;
    private String gender;
    public User(String sno, String name, Integer age, String gender) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
