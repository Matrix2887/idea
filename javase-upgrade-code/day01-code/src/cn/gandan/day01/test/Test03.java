package cn.gandan.day01.test;

import java.util.Calendar;

/*
    用程序判断2018年2月14日是星期几。
 */
public class Test03 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2018);
        c.set(Calendar.MONTH,02);
        c.set(Calendar.DAY_OF_MONTH,14);
        int i = c.get(Calendar.DAY_OF_WEEK);
        String[] week = {"","星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
        System.out.println("2018年2月14日是"+ week[i]);
    }
}
