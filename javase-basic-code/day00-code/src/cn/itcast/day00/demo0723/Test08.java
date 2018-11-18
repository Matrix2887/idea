package cn.itcast.day00.demo0723;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
获取键盘录入的字符串str ，随机从字符串str中获取5次字符 ，1次获取1个字符 ，
将获取的5个字符拼接成新字符串 ，如新字符串中有小写字符，将小写字符转换成大写字符 ，
在控制台打印输出最终的新字符串

 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        System.out.println("请输入");
        String str = sc.next();
        String str2 = str.toUpperCase();
        char[] arrayChar = str2.toCharArray();
        ArrayList<Character> arrayC = new ArrayList<>();
        for (int i = 0; i < arrayChar.length; i++) {
            arrayC.add(arrayChar[i]);
        }
        char[] array = new char[arrayChar.length];
        for (int i = 0; i < arrayChar.length; i++) {
            int r = ra.nextInt(arrayC.size());
            array[i] = arrayC.get(r);
            arrayC.remove(r);
        }
        System.out.println(Arrays.toString(array));
    }
}
