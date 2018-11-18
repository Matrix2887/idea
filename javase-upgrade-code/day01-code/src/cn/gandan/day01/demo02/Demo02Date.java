package cn.gandan.day01.demo02;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        dateA();
        dateB();
        dateC();
    }

    // Date类的空参数构造方法
    // Date()获取当前系统的日期和时间
    public static void dateA(){
        Date date = new Date();
        System.out.println(date);
    }
    // Date类的带参数构造方法
    // Date(long date):传递毫秒值,把毫秒值转换成为Date日期
    public static void dateB(){
        Date date = new Date(0L);
        System.out.println(date);
        date = new Date(4564641548612554848L);
        System.out.println(date);

    }
    // long getTime() 把日期转换为毫秒值(相当于System.currentTimeMillis()方法)
    // 返回自1970 年 1 月 1 日00:00:00 GMT以此来Date 对象表示的毫秒数
    public static void dateC(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }
}
