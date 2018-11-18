package cn.gandan.day10.demo03;

import java.io.*;

/*
    练习:转换文件编码
        将GBK编码的文件,转换为UTF-8编码的文本文件

        分析:
        1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称GBK
        2.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称UTF-8
        3.使用InputStreamReader对象中的方法read读取文件
        4.使用OutputStreamWriter对象中的方法write,把读取的数据写入到文件中
        5.释放资源
 */
public class Demo04Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fr = new FileInputStream("day10-code\\GBK.txt");
//        InputStreamReader gbk = new InputStreamReader(new FileInputStream("day10-code\\GBK.txt"), "GBK");
        FileOutputStream fw = new FileOutputStream("day10-code\\GBK_UTF-8.txt",true);
//        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("day10-code\\GBK_UTF-8.txt",true),"UTF-8");
        read_GBK(fr,fw);
//        fw.close();
//        fr.close();
//        int len;
//        while((len = gbk.read())!=-1){
//            out.write(len);
//        }
//        out.close();
//        gbk.close();
//    }

//    private static void write_UTF_8(FileOutputStream fileOutputStream,char len) throws IOException{
//        OutputStreamWriter out = new OutputStreamWriter(fileOutputStream,"UTF-8");
//        out.write(len);
//        out.flush();
    }

    private static void read_GBK(FileInputStream fileInputStream,FileOutputStream fileOutputStream) throws IOException {
        InputStreamReader gbk = new InputStreamReader(fileInputStream, "GBK");
        OutputStreamWriter out = new OutputStreamWriter(fileOutputStream,"UTF-8");
        int len;
        while((len = gbk.read())!=-1){
            out.write(len);
//            write_UTF_8(fileOutputStream,(char)len);
        }
        out.flush();
        gbk.close();
    }
}
