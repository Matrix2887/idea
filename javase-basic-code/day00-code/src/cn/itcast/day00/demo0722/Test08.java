package cn.itcast.day00.demo0722;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
1. 定义学生类Student，包含以下成员;
 成员属性:name(姓名):String类型，Chinese(语文):int类型，math(数学):int类型，属性使用private修饰。
 成员方法:
        (1).get/set方法，构造方法
        (2).void show()方法，打印对象所有属性的值以及对象的语文和数学成绩的总和到控制台
2. 定义类:Test类中定义main方法，按以下要求编写代码
      (1)定义如下方法；
         @定义public static ArrayList<Student> getSum(ArrayList<Student> list){...}方法；
         @@要求:遍历list集合，将list中语文成绩和数学成绩总和大于160分的元素存入到另一个ArrayList<Student>中并返回。
        (2)分别实例化三个Student对象，三个对象分别为：”李强”88,99,; “张强”,85,78,; “谢强”,86,50;
        (3)创建一个ArrayList集合，这个集合里面存储的是Student类型，分别将上面的三个Student对象添加到集合中，调用getSum方法，根据返回的list集合遍历对象并调用show()方法输出所有元素信息。

 */
public class Test08 {
    public static void main(String[] args) {
    ArrayList<Student> stu = new ArrayList<>();
    Student one = new Student("李强",88,99);
    Student two = new Student("张强",85,78);
    Student three = new Student("谢强",86,50);
    stu.add(one);
    stu.add(two);
    stu.add(three);
    ArrayList<Student> list = getSum(stu);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).show();
        }
    }
    public static ArrayList<Student> getSum(ArrayList<Student> list){
        ArrayList<Student> stu1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChinese() + list.get(i).getMath() > 160){
                stu1.add(list.get(i));
            }
        }
        return stu1;
    }
}
