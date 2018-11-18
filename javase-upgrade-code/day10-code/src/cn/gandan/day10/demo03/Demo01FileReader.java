package cn.gandan.day10.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    FileReader可以读取IDE默认编码格式(UTF-8)的文件
    FileReader读取系统默认编码(中文GBK)会产生乱码���
 */
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day10-code\\GBK.txt");
        int len;
        while((len=fr.read())!=-1){
            System.out.print((char)len);
        }
        fr.close();

    }
}
