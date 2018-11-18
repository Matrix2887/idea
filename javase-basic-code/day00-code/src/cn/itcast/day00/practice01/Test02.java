package cn.itcast.day00.practice01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
定义String类型数组，存储键盘录入的5个字符串，定义方法，传递该数组，方法功能如下：
（1）将数组中字符串长度为偶数的元素存储到集合1中
（2）将数组中包含数字字符的字符串存储到集合2中
（3）打印集合内元素，格式如下：
长度为偶数的字符串：......
包含数字的字符串：......
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[5];
        for (int i = 0; i < str.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个字符串");
            str[i] = sc.next();
        }
            ArrayList<String> arrayStr1 =arr1(str);
            ArrayList<String> arrayStr2 =arr2(str);
        System.out.println("长度为偶数的字符串:" + arrayStr1);
        System.out.println("包含数字的字符串:" + arrayStr2);
    }
    public static ArrayList<String> arr1(String[] str){
        ArrayList<String> arrayStr1 = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
        if(str[i].length() % 2 == 0){
            arrayStr1.add(str[i]);
        }
        }
        return arrayStr1;
    }
    public static ArrayList<String> arr2(String[] str){
        ArrayList<String> arrayStr2 = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            char[] charArray = str[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if(charArray[j] >= '0' && charArray[j] <= '9'){
                    arrayStr2.add(str[i]);
                    break;
                }
            }
        }
        return arrayStr2;
    }
}
