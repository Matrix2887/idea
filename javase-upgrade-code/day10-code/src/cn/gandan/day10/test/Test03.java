package cn.gandan.day10.test;

import java.io.*;
import java.util.ArrayList;

/*
分析以下需求，并用代码实现
	1.定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,生成空参有参构造,set和get方法,toString方法
	2.创建4个学生对象,将4个学生对象存入到ArrayList集合中
	3.将存有4个学生对象的ArrayList集合对象写入到D:\\StudentInfo.txt文件中
	4.读取D:\\StudentInfo.txt文件中的ArrayList对象并遍历打印
	5.要求使用序列化流来实现
 */
public class Test03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("盛利","女",20));
        students.add(new Student("爆米花","女",18));
        students.add(new Student("小女巫","女",22));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day10-code\\StudentInfo.txt"));
        oos.writeObject(students);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day10-code\\StudentInfo.txt"));
        Object o = ois.readObject();
        ArrayList<Student> student = (ArrayList<Student>)o;
        for (Student s : student) {
            System.out.println(s);
        }
    }
}
