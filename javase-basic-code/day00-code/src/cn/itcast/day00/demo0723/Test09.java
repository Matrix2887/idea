package cn.itcast.day00.demo0723;

import java.util.Arrays;

/*
1、编写一个无返回值，参数为String类型的方法，实现以下功能：
a.将传入的字符串中的大写字母变成小写字母，小写字母变成大写字母，其余字符不变。并且统计转换了多少次（大小写转换总和）
b.在控制台打印输出转换后的字符串以及转换总次数
2、在main方法中键盘录入一个字符串，并将该字符串传入上述方法中，调用测试。

 */
public class Test09 {
    public static void main(String[] args) {
    String str = "hdrhhgrkg";
    convert(str);
    }
    public static void convert(String str){
        int countBig = 0;
        int countSmall = 0;
            char[] charNum = str.toCharArray();
            for (int j = 0; j < charNum.length; j++) {
                char thing = charNum[j];
                if ('A' <= thing && thing <= 'Z'){
                    charNum[j] = (char)(charNum[j] + 32);
                    countBig++;
                }else if('a' <= thing && thing <= 'z'){
                    charNum[j] = (char)(charNum[j] - 32);
                    countSmall++;
                }
            }
        System.out.println("小字母转换" + countSmall + "次");
        System.out.println("大字母转换" + countBig + "次");
        }

}
