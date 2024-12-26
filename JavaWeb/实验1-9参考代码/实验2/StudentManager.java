package mypackage;

import java.util.*;

public class StudentManager {
    //【代码一】声明HashMap集合对象

    private Map<String, Student> map;
    public StudentManager() {
        //创建集合对象
        map = new TreeMap();
        //创建学生对象
        Student s = new Student("181305", "xws", 100);
        Student s1 = new Student("181306", "xxs", 90);
        Student s2 = new Student("181307", "wws", 99);
        //学生对象添加到集合
        map.put("181305", s);
        map.put("181306", s1);
        map.put("181307", s2);
    }

    //显示所有学生信息
    public void showStu() {
        if (map.isEmpty()) {
            System.out.println("没有学生");
        } else {
            System.out.println("一共有" + map.size() + "个学生");
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
        }
    }

    //添加一个学生
    public void addStu(Student student) {
        String key = student.getId(); //【代码二】
        map.put(key, student);
        System.out.println("添加学生成功");
        showStu();
    }

    //根据学号，查找一个学生
    public void selectStu(String id) {
        if (map.containsKey(id)) {
            Student stu = map.get(id);/*【代码三】*/
            System.out.println(stu);
        } else {
            System.out.println("没有这个学号的学生");
        }
    }

    //根据学号更新学生基本信息
    public void updateStu(String id, String name, int grade) {
        if (map.containsKey(id) /*【代码四】*/) {
            Student stu = map.get(id);
            stu.setName(name);//【代码五】设置学生的姓名及成绩
            stu.setGrade(grade);
            System.out.println("学生信息更新成功");
            showStu();
        } else {
            System.out.println("没有这个学号的学生");
        }
    }

    //根据学号删除学生
    public void deleteStu(String id) {
        if (map.containsKey(id)) {            
            map.remove(id);//【代码六】
            System.out.println("学生删除成功");
            showStu();
        } else {
            System.out.println("没有这个学号的学生");
        }
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.showStu();
        System.out.println("=============================================");
        studentManager.selectStu("990001");
        studentManager.selectStu("181305");
        System.out.println("=============================================");
        studentManager.addStu(new Student("990002", "lucy", 90));
        System.out.println("=============================================");
        studentManager.deleteStu("990001");
        studentManager.deleteStu("990002");
        System.out.println("=============================================");
        studentManager.updateStu("990001", "mary", 90);
        studentManager.updateStu("181305", "mary", 90);

    }
}
