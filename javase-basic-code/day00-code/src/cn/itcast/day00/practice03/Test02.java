package cn.itcast.day00.practice03;

import java.util.Random;
import java.util.Scanner;

/*
1.键盘录入一个长度大于10的字符串
2.定义方法String getStr(String str),方法内实现,
(1)从字符串中随机获取5次字符,
(2)将获取的字符中的大写字符转换成小写字符,
(3)将转换后的字符组合成新的字符串,并将该字符串返回
3.main方法中进行测试
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("键入字符串");
        String str = sc.nextLine();
        System.out.println(str);
        String str1 = getStr(str);
        System.out.println(str1);
    }
    public static String getStr(String str){
        Random ra = new Random();
        char[] arr = new char[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(ra.nextInt(str.length()));
        }
        String arrStr = new String(arr);
        return arrStr.toLowerCase();
    }
}
