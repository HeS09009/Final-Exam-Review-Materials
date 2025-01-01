import java.util.*;
public class a {
    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        //1、添加元素
        //1.1 在List末尾添加元素
        list.add(new Student(12,"张三"));
        list.add(new Student(13, "李四"));
        //1.2 在指定位置添加元素
        list.add(0, new Student(11,"小明"));
        System.out.println(list);

        //2、根据索引位置，取出元素
        Student student = list.get(2);
        System.out.println(student.getAge());

        //3、判断list集合中是否包含某元素
        System.out.println("是否包含指定的Student对象："+list.contains(new Student(12, "张三")));
        //必须重写Student的equals方法，才能返回true

        //4、返回list集合中第一次出现元素的索引位置
        int index = list.indexOf(new Student(12, "张三"));
        System.out.println("某Student对象第一次出现的位置:" + index);

        //5、删除元素
        //5.1 根据索引位置，删除元素
        Student elem = list.remove(1);
        System.out.println("被删除的元素为：" + elem);
        //5.2 从List中删除指定的元素
        //被删除的Student对象必须“equals”List中的某元素，才能返回true
        System.out.println(list.remove(new Student(13, "李四")));

        //6、修改指定位置的元素
        Student old = list.set(0, new Student(11,"小红"));
        System.out.println("原来的元素为：" + old);

        //7、遍历集合中的元素
        //第一种：传统的for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
            //输出一个对象，默认调用对象的toString()方法
        }
        System.out.println("\n=======================================================");
        ///第二种：增强的for循环变量，jdk1.5后可用
        for (Student obj : list) {
            System.out.print(obj + "\t");
        }
        System.out.println("\n=====================================================");
        //第三种：迭代器（while版本）
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+"\t");
        }
        System.out.println("\n=====================================================");
        //第四种：迭代器（for版本）
        for(Iterator<Student> iterator = list.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+"\t");
        }
    }
}
