package cn.itcast.day00.practice02;

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
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void showMsg(){
        System.out.println("姓名:" + name + ",年龄:" + age);
    }
}
