package cn.itcast.day00.demo0722;

import java.util.ArrayList;
import java.util.Arrays;

/*
(1)定义数组,存储如下数据:"hElLo1","wOrLd002","jAVA3","bEst!","loVe","enJoy#"
(2)定义方法,统计数组中大写,小写,数字字符的个数并进行打印,打印格式如下:
大写字符: 个
小写字符: 个
数字字符: 个
(3)定义方法,将字符串中包含数字的字符串替换成"*",并打印结果,打印格式如下:
替换前:["hElLo1","wOrLd002","jAVA3","bEst!","loVe","enJoy#"]
替换后:["*","*","*","bEst!","loVe","enJoy#"]
(4)定义方法,将字码表值转换,大写转小写+32,小写转大写-32),其他字符不变并打印结果,打印格式如下:
转换前:["*","*","*","bEst!","loVe","enJoy#"]符串的小写转换成大写,大写转换成小写
转换后:[*, *, *, BeST!, LOvE, ENjOY#]
 */
public class Test12 {
    public static void main(String[] args) {
       String[] str ={"\"hElLo1\"","\"wOrLd002\"","\"jAVA3\"","\"bEst!\"","\"loVe\"","\"enJoy#\""};
       number(str);
        System.out.print("替换前:");
        System.out.println(Arrays.toString(str));
        System.out.print("替换后:");
       replaceNum(str);
       convert(str);

    }
    public static void number(String[] str){
        int countUpper = 0;
        int countLower = 0;
        int countNunber = 0;
        int countOther = 0;
        for (int i = 0; i < str.length; i++) {
        char[] charArray = str[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char thing = charArray[j];
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
        }
            System.out.println("大字母有" + countUpper + "个");
            System.out.println("小字母有" + countLower + "个");
            System.out.println("数字有" + countNunber + "个");
            System.out.println("其他有" + countOther + "个");
    }

    public static void replaceNum(String[] str){
        for (int i = 0; i < str.length; i++) {
            char[] charArray = str[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char thing = charArray[j];
                if ('0' <= thing && thing <= '9') {
                    str[i] = str[i].replace(str[i],"\"*\"");
                }
            }
        }
        System.out.println(Arrays.toString(str));
    }

    public static void convert(String[] str){
        System.out.print("转换前:");
        replaceNum(str);
        for (int i = 0; i < str.length; i++) {
            char[] charNum = str[i].toCharArray();
            for (int j = 0; j < charNum.length; j++) {
                char thing = charNum[j];
                if ('A' <= thing && thing <= 'Z'){
                    charNum[j] = (char)(charNum[j] + 32);
                }else if('a' <= thing && thing <= 'z'){
                    charNum[j] = (char)(charNum[j] - 32);
                }
                str[i] = new String(charNum);
            }
            str[i] = str[i].replace("\"","");
        }
        System.out.print("转换后:");
        System.out.println(Arrays.toString(str));
    }
}
