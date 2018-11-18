package cn.itcast.day06.demo05;

public class Demo01Stuent {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("迪丽热巴");
        stu1.setAge(20);
        System.out.println("姓名"+stu1.getName()+"年龄"+ stu1.getAge());
        System.out.println("=============");
        Student stu2 = new Student();
        stu2.setName("胡歌");
        stu2.setAge(23);
        System.out.println("姓名"+stu2.getName()+"年龄"+ stu2.getAge());
    }
}
