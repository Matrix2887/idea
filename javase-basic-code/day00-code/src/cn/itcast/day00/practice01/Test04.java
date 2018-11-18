package cn.itcast.day00.practice01;

import java.util.ArrayList;
import java.util.List;

/*
（1）定义Student类，属性：score(成绩：double类型)，age(年龄：int类型)
（2）定义Check类，方法：test，方法所需参数Student类对象，方法功能如下：
对学生成绩进行四舍五入
（3）1.定义测试类Test04，在main方法中创建5个学生对象，对象信息通过键盘录入获取
并将学生对象存储到集合1中，打印集合中对象的属性信息
2.使用test方法，对学生对象的成绩进行操作，将操作后的学生对象存储到集合2中，
打印集合中对象的属性信息
 */
public class Test04 {
    public static void main(String[] args) {
        Check check = new Check();
        Student one = new Student(80.5,5);
        Student two = new Student(75.3,6);
        Student three = new Student(100,3);
        Student four = new Student(560.3,4);
        Student five = new Student(50.55,5);
        // 在已经获取了所有的元素的情况下,才能使用
        ArrayList<Student> students = new ArrayList<>(List.of(one,two,three,four,five));
        ArrayList<Student> students1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
        students.get(i).show();
        students1.add(students.get(i));
        students1.get(i).setScore(check.test(students1.get(i)));
        }
        System.out.println("=====================");
        for (int i = 0; i < students1.size(); i++) {
            students1.get(i).show();
        }

    }
}
