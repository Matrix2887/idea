package cn.itcast.day08.demo03;

/*
如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类。多个对象共享同一份数据。
 */
public class Demo01StaticField {
    public static void main(String[] args) {
        Student two = new Student("小兰",16);
        two.room = "二年级3班";
        Student one  = new Student("新一", 17);

        System.out.println("姓名:" + one.getName() + " 年龄:" + one.getAge() + " 学号:" + one.getId()  + " 教室:" + one.room);
        System.out.println("姓名:" + two.getName() + " 年龄:" + two.getAge() + " 学号:" + two.getId()  + " 教室:" + two.room);
    }
}
