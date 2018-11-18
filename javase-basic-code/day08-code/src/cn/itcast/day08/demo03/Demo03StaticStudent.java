package cn.itcast.day08.demo03;

/*
14 14 14 14 14 14 14 14 14 14 14 14 14
注意：
根据类名称访问静态成员变量的时候，
全程和对象就没关系，只和类有关系
 */
public class Demo03StaticStudent {
    public static void main(String[] args) {
        // 首先设置一下教室，这是静态的东西，应该通过类名称进行调用
        Student.room = "二年级3班";

        Student one = new Student("新一",17);
        System.out.println("姓名:" + one.getName());
        System.out.println("年龄" + one.getAge());
        System.out.println("教室" + Student.room);
        System.out.println("=====================");

        Student two = new Student("小兰",160);
        System.out.println("姓名" + two.getName());
        System.out.println("年龄" + two.getAge());
        System.out.println("教室" + Student.room);
    }
}
