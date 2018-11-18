package cn.gandan.day01.demo03;

import java.util.Calendar;
import java.util.Date;

/*
    Calendar类的常用成员方法:
        public int get(int field):返回给定日历字段的值
        public void set(int field,int value):将给定的日历字段设置为给定值
        public abstract void add(int field,int amount):根据日历的规则,为给定的日历字段添加或减去指定的时间量
        public Date getTime():返回一个表示此Calendar时间值(从历元到现在的毫秒偏移量)的Date对象
    成员方法的参数:
        int field:日历类的字段,可以使用Calendar类的静态成员变量获取
            public static final int YEAR = 1;           年
            public static final int MONTH = 2;          月
            public static final int DATE = 5;           月中的某一天
            public static final int DAY_OF_MONTH = 5;   月中的某一天
            public static final int HOUR = 10;          时
            public static final int MINUTE = 12;        分
            public static final int SECOND = 13;        秒
 */
public class Demo02Calendar {
    public static void main(String[] args) {
        get_Time();
        System.out.println("==========");
        setTime();
        System.out.println("==========");
        addTime();
        System.out.println("==========");
        getTime_();
    }
    /*
    public int get(int field):返回给定日历字段的值
    参数: 传递指定的日历字段(YEAR,MONTH...)
    返回值:日历字段代表的具体的值
     */
    public static void get_Time(){
        // 使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);
        int month = c.get(Calendar.MONTH);
        System.out.println(month);// 西方月份0-11

        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
    /*
        public void set(int field,int value):将给定的日历字段设置为给定值
        参数:
            int field:传递指定的日历字段(YEAR,MONTH...)
            int value:给指定字段设置的值
     */
    public static void setTime(){
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        // 设置年为2016年
        c.set(Calendar.YEAR,2016);
        // 设置为4月
        c.set(Calendar.MONTH,04);
        // 设置为23日
        c.set(Calendar.DAY_OF_MONTH,23);
        // 同时设置年月日,使用set的重载方法
        c.set(2016,04,23);

        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);// 西方月份0-11

        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }

    /*
        public abstract void add(int field,int amount):根据日历的规则,为给定的日历字段添加或减去指定的时间量
        把指定的字段增加/减少指定的值
        参数:
            int field:传递指定的日历字段(YEAR,MONTH...)
            int amount:增加/减少指定的值
            正数:增加
            负数:减少
     */
    public static void addTime(){

        Calendar c = Calendar.getInstance();
        // 把年增加2年
        c.add(Calendar.YEAR,2);
        // 把月份减少3个月
        c.add(Calendar.MONTH,-2);

        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);// 西方月份0-11

        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
    /*
        public Date getTime():返回一个表示此Calendar时间值(从历元到现在的毫秒偏移量)的Date对象
        把日历对象转换为日期对象
     */
    public static void getTime_(){
        Calendar c = Calendar.getInstance();

        Date date = c.getTime();
        System.out.println(date);

    }
}
