package cn.itcast.day00.demo0723;

/*
编写一个Java程序，定义一个String字符串"   ab123cd  "，首先去除字符串两端的空白，然后截取出字符串中的最后3个字符并在控制台输出。

 */
public class Test07 {
    public static void main(String[] args) {
        String str = "   ab123cd  ";
        String str1 = str.trim();
        String str2 = str1.substring(4);
        System.out.println(str2);
    }
}
