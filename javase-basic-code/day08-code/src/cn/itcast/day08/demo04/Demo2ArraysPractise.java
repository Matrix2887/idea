package cn.itcast.day08.demo04;

import java.util.Arrays;

/*
题目:
请使用Arrays相关的API,将一个随机字符串中的所有字符升序排列,并倒序打印

如何进行升序排列:sort
必须是一个数组,才能用Arrays.sort方法
String --> 数组,用toCharArray
 */
public class Demo2ArraysPractise {
    public static void main(String[] args) {
        String str = "adddfdu16415666dgcccagdvjfjujdiitkh.,/.;,,.....,GHJDGJFGRDGGYEFYUDSGYUFGRHFCYFYEFIRE,dl%$%^$^$^%&^%&%&&%^$^$%#$%@#!#@$%$^^&%fggh8787,.,.,..zkasee'78s4fs55e...mlkjiinnjeruu67566dfadsfhhfhj";

        // 如何进行升序排列:sort
        // 必须是一个数组，才能用Arrays.sort方法
        // String --> 数组,用toCharArray
        char[] c = str.toCharArray();
        Arrays.sort(c);// 对字符数组进行升序排列

        // 需要倒序遍历
        for (int i = c.length - 1; i >= 0; i--) {// forr
            System.out.print(c[i]);
        }
    }
}
