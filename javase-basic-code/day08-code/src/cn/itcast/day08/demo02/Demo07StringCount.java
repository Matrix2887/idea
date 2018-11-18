package cn.itcast.day08.demo02;

import java.util.ArrayList;
import java.util.Scanner;

/*
题目：
键盘输入一个字符串，并且统计其中各种字符出现的次数
种类有：大写字母、小写字母、数字、其他

思路：
1.既然用到键盘输入，肯定是Scanner
2.键盘输入的是字符串，那么：String str = sc.next();
3.定义四个变量，分别代表四种字符各自的出现次数
4.需要对字符串一个字、一个字检查，String-->char[],方法就是toCharArray()
5.遍历char[]字符数组，对当前字符的种类进行判断，并且用四个变量进行++动作
6.打印输出四个变量，分别代表四种字符出现次数
 */
public class Demo07StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bigLetter = 0;
        int littleLetter = 0;
        int num = 0;
        int rest = 0;
        int countUpper = 0;
        int countLower = 0;
        int countNunber = 0;
        int countOther = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        System.out.println("请输入");
        String str = sc.next();
        ArrayList<Integer> list = toCharArray(str);
        for (int i = 0; i < str.length(); i++) {
            if(list.get(i) >= 48 && list.get(i) <= 57){
                num++;
            }else if(list.get(i) >= 65 && list.get(i) <= 90){
                bigLetter++;
            }else if(list.get(i) >= 97 && list.get(i) <= 122){
                littleLetter++;
            }else{
                rest++;
            }
        }
        System.out.println("大字母有" + bigLetter + "个");
        System.out.println("小字母有" + littleLetter + "个");
        System.out.println("数字有" + num + "个");
        System.out.println("其他有" + rest + "个");
        System.out.println("=====================");
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char thing = charArray[i];
            if ('A' <= thing && thing <= 'Z'){
                countUpper++;
            }else if('a' <= thing && thing <= 'z'){
                countLower++;
            }else if('0' <= thing && thing <= '9'){
                countNunber++;
            }else{
                countOther++;
            }
        }
        System.out.println("大字母有" + countUpper + "个");
        System.out.println("小字母有" + countLower + "个");
        System.out.println("数字有" + countNunber + "个");
        System.out.println("其他有" + countOther + "个");
        System.out.println("=================");
        byte[] bytesArray = str.getBytes();
        for (int i = 0; i < bytesArray.length; i++) {
            if(bytesArray[i] >= 48 && bytesArray[i] <= 57){
                c++;
            }else if(bytesArray[i] >= 65 && bytesArray[i] <= 90){
                a++;
            }else if(bytesArray[i] >= 97 && bytesArray[i] <= 122){
                b++;
            }else{
                d++;
            }
        }
        System.out.println("大字母有" + a + "个");
        System.out.println("小字母有" + b + "个");
        System.out.println("数字有" + c + "个");
        System.out.println("其他有" + d + "个");
    }
    public static ArrayList<Integer> toCharArray(String str){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
           list.add((int)str.charAt(i));
        }
        return list;
    }
}
