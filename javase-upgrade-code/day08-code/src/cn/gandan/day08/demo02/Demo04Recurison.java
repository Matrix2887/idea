package cn.gandan.day08.demo02;

import java.io.File;

/*
 练习:
        递归打印多级目录
    需求:
        遍历c:\\abc文件夹,及abc文件夹的子文件夹
        c:\\abc
        c:\\abc\\abc.txt
        c:\\abc\\abc.java
        c:\\abc\\a
        c:\\abc\\a\\a.jpg
        c:\\abc\\a\\a.java
        c:\\abc\\b
        c:\\abc\\b\\b.java
        c:\\abc\\b\\b.txt
 */
public class Demo04Recurison {
    public static void main(String[] args) {
        File file = new File("D:\\Java\\utorrent\\apps\\D944B3378FAB35793B7951FA53E41B2AB9CC462B");
        getAllFile(file,0);
        System.out.println("=================");
        getAll(file);
    }

    private static void getAllFile(File dir,int a) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                getAllFile(file,a);
            }else{
                System.out.println(file + "------------>" + (a++));
            }
        }
    }
    private static void getAll(File di){
        System.out.println(di);
        File[] files = di.listFiles();
        for (File file : files) {
            if(file.isFile()){
                System.out.println(file);
            }else {
                getAll(file);
            }
        }
    }
}
