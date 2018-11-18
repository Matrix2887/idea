package cn.gandan.day01.demo02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
题目:计算已经出生多少天
 */
public class Demo04Birthday {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期,格式为\"yyyy-MM-dd\"");
        String str = sc.nextLine();
        str = "1997-10-19";
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date date = s.parse(str);
//        System.out.println(date);
        Long da = date.getTime();
//        System.out.println(da);
        da = System.currentTimeMillis() - da;
        long year = da / 86400000 / 365;
        long d = da - (year * 365 * 86400000);
        long day = d / 86400000;

        System.out.println("过去了" + year + "年又" + day + "天");

    }
}
