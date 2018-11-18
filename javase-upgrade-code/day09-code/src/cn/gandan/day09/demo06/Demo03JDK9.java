package cn.gandan.day09.demo06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
开发时少用
既要throws 又要 try...catch

    JDK9新特性
    try的前边可以定义流对象
    在try后边的()中可以直接引入流对象的名称(变量名)
    在try代码执行完毕之后,流对象也可以释放掉,不用写finally
    格式:
        A a = new A();
        B b = new B();
        try(a,b){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }
 */
public class Demo03JDK9 {
    public static void main(String[] args) throws IOException {
        //1.创建一个字节输入流对象,构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\图片\\动漫\\5.jpg");// 取出
        //2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("D:\\视频\\5.jpg");// 写入
        try(fis;fos){
            //一次读取一个字节写入一个字节的方式
            //3.使用字节输入流对象中的方法read读取文件
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                //4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
//        while ((len = fis.read()) != -1){
                System.out.println(Arrays.toString(bytes));
//            System.out.println(len);
                fos.write(len);
            }
        }catch (IOException e){
            System.out.println(e);
        }
        //fos.write(1);//Stream Closed
    }
}
