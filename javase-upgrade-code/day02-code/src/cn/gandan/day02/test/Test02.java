package cn.gandan.day02.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
定义一个学生类Student，包含三个属性姓名、年龄、性别，创建三个学生对象存入ArrayList集合中。
	A：使用迭代器遍历集合。
	B：求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。
 */
public class Test02 {
    public static void main(String[] args) {
        Student s1 = new Student("艾登.皮尔斯",35,"男");
        Student s2 = new Student("ASH",20,"女");
        Student s3 = new Student("IQ",35,"女");
        ArrayList<Student> students = new ArrayList<>(List.of(s1,s2,s3));

        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
//        int count = students.get(0).getAge();
        Student big = s1;
        for(Student student:students){
            if(student.getAge() >= big.getAge()){
//                count = student.getAge();
                big = student;
            }
        }
        big.setName("大哥");
        System.out.println(big);
    }
}
