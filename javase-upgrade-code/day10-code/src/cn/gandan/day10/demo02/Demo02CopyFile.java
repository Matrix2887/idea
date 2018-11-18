package cn.gandan.day10.demo02;

import java.io.*;
import java.util.Arrays;

// 21374 32760 23323
public class Demo02CopyFile {
    public static void main(String[] args) throws IOException {
        // 1.创建一个字节输入流对象,构造方法中绑定要读取的数据源
        long l = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\视频\\剧场版 妄xiang学生会.rmvb");// 取出
        // 2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("D:\\视频\\Devil May Cry 5.mp4");// 写入
        // 3.使用字节输入流对象中的方法read读取文件
//        int len;
//        while ((len = fis.read(bytes)) != -1){
//        // 4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
////        while ((len = fis.read()) != -1){
////            System.out.println(Arrays.toString(bytes));
////            System.out.println(len);
//            fos.write(bytes,0,len);
//        }
        BufferedInputStream bis = new BufferedInputStream(fis,1024);
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
//            System.out.println(Arrays.toString(bytes));
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();

        // 5.释放资源(先关写的,后关闭读的;如果写完了,肯定读取完毕了)
//        fos.close();
//        fis.close();
        long o = System.currentTimeMillis();
        System.out.println("耗时" + (o-l) + "毫秒");
    }
}
