package cn.gandan.day10.test;

import java.io.*;

/*
分析以下需求，并用代码实现
	实现一个验证程序运行次数的小程序，要求如下：
	1.当程序运行超过3次时给出提示:本软件只能免费使用3次,欢迎您注册会员后继续使用~
	2.程序运行演示如下:
		第一次运行控制台输出: 欢迎使用本软件,第1次使用免费~
		第二次运行控制台输出: 欢迎使用本软件,第2次使用免费~
		第三次运行控制台输出: 欢迎使用本软件,第3次使用免费~
		第四次及之后运行控制台输出:本软件只能免费使用3次,欢迎您注册会员后继续使用~
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day10-code\\test.txt");
        int len;
        String count = "";
        while((len = fr.read()) != -1){
            count += (char)len;
        }
        int i = Integer.parseInt(count);
        i++;
        count = i + "";
        FileWriter fw = new FileWriter("day10-code\\test.txt",true);
        if(i <= 3){
        System.out.println("欢迎使用本软件,第"+i+"次使用免费~");
            fw.write(count);
            System.out.println(count);
        }else {
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
        }

        fw.close();
        fr.close();
    }
}
