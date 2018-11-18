package cn.gandan.day01.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日。
 */
public class Test02 {
    public static void main(String[] args) throws ParseException {
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String time = s.format(date);
    System.out.println(time);
    date = s.parse(time);
    SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日");
    System.out.println(date);
        System.out.println(d.format(date));
    }
}
