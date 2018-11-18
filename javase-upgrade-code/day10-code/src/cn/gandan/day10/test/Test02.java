package cn.gandan.day10.test;

import java.io.*;
import java.util.Scanner;

/*
分析以下需求，并用代码实现
	1.从键盘接收一个小视频路径
	2.将这个视频复制到D盘下avi文件中
	3.要求使用缓冲流来实现
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入路径");
        String fileAvi = sc.nextLine();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileAvi));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day10-code\\avi.mp4"));
        int len;
        byte[] bytes = new byte[1024];
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }
}
