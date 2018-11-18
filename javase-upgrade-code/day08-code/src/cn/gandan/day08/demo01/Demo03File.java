package cn.gandan.day08.demo01;

import java.io.File;

/*
    File类获取功能的方法
        - public String getAbsolutePath() ：返回此File的绝对路径名字符串。
        - public String getPath() ：将此File转换为路径名字符串。
        - public String getName()  ：返回由此File表示的文件或目录的名称。
        - public long length()  ：返回由此File表示的文件的长度。
 */
public class Demo03File {
    public static void main(String[] args) {
        absolutePath();
        System.out.println("=======================");
        pathGet();
        System.out.println("=======================");
        nameGet();
        System.out.println("=======================");
        lengthLong();

    }


    /*
           public String getAbsolutePath() ：返回此File的绝对路径名字符串。
           获取的构造方法中传递的路径
           无论路径是绝对的还是相对的,getAbsolutePath方法返回的都是绝对路径
        */
    private static void absolutePath() {
        File f1 = new File("D:\\游戏\\亲爱的选择.rar");
        File absoluteFile1 = f1.getAbsoluteFile();
        System.out.println(absoluteFile1);

        File f2 = new File("亲爱的选择.rar");
        File absoluteFile2 = f2.getAbsoluteFile();
        System.out.println(absoluteFile2);

    }

    /*
      public String getPath() ：将此File转换为路径名字符串。
      获取的构造方法中传递的路径

      toString方法调用的就是getPath方法
      源码:
          public String toString() {
              return getPath();
          }
   */
    private static void pathGet() {
        File f1 = new File("D:\\游戏\\亲爱的选择.rar");
        File f2 = new File("亲爱的选择.rar");
        String path1 = f1.getPath();
        String path2 = f2.getPath();
        System.out.println(path1);// D:\游戏\亲爱的选择.rar
        System.out.println(path2);// 亲爱的选择.rar

        System.out.println(f1);// D:\游戏\亲爱的选择.rar
        System.out.println(f2.toString());// 亲爱的选择.rar

    }

    /*
     public String getName()  ：返回由此File表示的文件或目录的名称。
     获取的就是构造方法传递路径的结尾部分(文件/文件夹)
  */
    private static void nameGet() {
        File f1 = new File("D:\\游戏\\亲爱的选择.rar");
        String name1 = f1.getName();
        System.out.println(name1);// 亲爱的选择.rar
        File f2 = new File("亲爱的选择.rar");
        String name2 = f2.getName();
        System.out.println(name2);// 亲爱的选择.rar

    }



    /*
       public long length()  ：返回由此File表示的文件的长度。
       获取的是构造方法指定的文件的大小,以字节为单位
       注意:
           文件夹是没有大小概念的,不能获取文件夹的大小
           如果构造方法中给出的路径不存在,那么length方法返回0
    */
    private static void lengthLong() {
        File f1 = new File("D:\\游戏\\亲爱的选择.rar");
        File f2 = new File("D:\\Youku Files");
        File f3 = new File("C:\\亲爱的选择.rar");
        long l1 = f1.length();
        long l2 = f2.length();
        long l3 = f3.length();
        System.out.println(l1);// 11515187036字节
        System.out.println(l2);
        System.out.println(l3);


    }
}
