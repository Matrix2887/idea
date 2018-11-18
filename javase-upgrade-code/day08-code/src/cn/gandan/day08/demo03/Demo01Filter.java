package cn.gandan.day08.demo03;

import java.io.File;

/*
    需求:
        遍历c:\\abc文件夹,及abc文件夹的子文件夹
        只要.java结尾的文件
        c:\\abc
        c:\\abc\\abc.txt
        c:\\abc\\abc.java
        c:\\abc\\a
        c:\\abc\\a\\a.jpg
        c:\\abc\\a\\a.java
        c:\\abc\\b
        c:\\abc\\b\\b.java
        c:\\abc\\b\\b.txt
    我们可以使用过滤器来实现
    在File类中有两个和ListFiles重载的方法,方法的参数传递的就是过滤器
    File[] listFiles(FileFilter filter)
    java.io.FileFilter接口:用于抽象路径名(File对象)的过滤器。
        作用:用来过滤文件(File对象)
        抽象方法:用来过滤文件的方法
            boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中。
            参数:
                File pathname:使用ListFiles方法遍历目录,得到的每一个文件对象
    File[] listFiles(FilenameFilter filter)
    java.io.FilenameFilter接口:实现此接口的类实例可用于过滤器文件名。
        作用:用于过滤文件名称
        抽象方法:用来过滤文件的方法
            boolean accept(File dir, String name) 测试指定文件是否应该包含在某一文件列表中。
            参数:
                File dir:构造方法中传递的被遍历的目录
                String name:使用ListFiles方法遍历目录,获取的每一个文件/文件夹的名称
    注意:
        两个过滤器接口是没有实现类的,需要我们自己写实现类,重写过滤的方法accept,在方法中自己定义过滤的规则
 */
public class Demo01Filter {
    public static void main(String[] args) {
        File file = new File("D:\\A\\Java se 基础班 basic\\Java ee第一天");
        getAllFile(file, 0);
    }

    private static void getAllFile(File dir, int a) {
//        System.out.println(dir);
//        File[] files = dir.listFiles(new FileFilterImpl());
//        File[] files = dir.listFiles((File pathName)->{
//            return pathName.isDirectory()||pathName.getPath().toLowerCase().endsWith(".java");
//        });
//        File[] files = dir.listFiles((pathName)->pathName.isDirectory()||pathName.getPath().toLowerCase().endsWith(".java"));
//        File[] files = dir.listFiles((path,name)->new File(path,name).isDirectory()||name.toLowerCase().endsWith(".java"));
        File[] files = dir.listFiles((path,name)->{
            System.out.println("path---->" + path);
            System.out.println("name---->" + name);
            return new File(path,name).isDirectory()||name.toLowerCase().endsWith(".java");});
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file, a);
            } else {
                System.out.println(file);
            }
        }
    }
}