package cn.gandan.day09.demo05;

import java.io.FileWriter;
import java.io.IOException;

/*
 字符输出流写数据的其他方法
        - void write(char[] char)写入字符数组。
        - abstract  void write(char[] char, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        - void write(String str)写入字符串。
        - void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 */
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day09-code\\f.txt");
        char[] ch = {'a','b','c','d','e'};
        //void write(char[] cbuf)写入字符数组。
        fw.write(ch);//abcde

        //void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        fw.write(ch,1,3);
        //void write(String str)写入字符串。
        fw.write("little");
        //void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        fw.write("start",1,3);

        // 释放资源
        fw.close();

    }
}
