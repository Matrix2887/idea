package cn.itcast.day00.practice02;

import java.util.ArrayList;
import java.util.List;

/*
(1)定义Student类,属性私有:姓名name,String类型;年龄age,int类型
方法:提供空参满参构造方法,set/get方法,showMsg方法(打印学生信息,格式:姓名:***,年龄:**)
(2)在测试类中创建三个学生对象,信息如下"东方不败",20;"任盈盈",16;"令狐冲",18;
定义结合,存储三个学生对象
(3)遍历集合,将对象姓名长度为偶数的对象删除,将对象姓名为"任"开头的对象的年龄修改为18
(4)打印集合中对象的信息,打印格式如下:
姓名:任盈盈,年龄:18
姓名:令狐冲,年龄:18
 */
public class Test03 {
    public static void main(String[] args) {
        Student st1 = new Student("东方不败",20);
        Student st2 = new Student("任盈盈",16);
        Student st3 = new Student("令狐冲",18);
        ArrayList<Student> students = new ArrayList<>(List.of(st1,st2,st3));
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().length() % 2 == 0) {
                students.remove(i);
                i--;
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().startsWith("任")){
                students.get(i).setAge(18);
            }
            students.get(i).showMsg();
        }
    }
}
