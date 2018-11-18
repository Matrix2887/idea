package cn.gandan.day08.test;

import java.io.File;
import java.util.Objects;

/*
    使用文件过滤器来打印出D盘下的所有.txt文件名称
 */
public class Test03 {
    public static void main(String[] args) {
        File file = new File("D:\\");
//        String[] list = file.list();
//        for (String s : list) {
//            System.out.println(s);
//        }
//        File[] files = file.listFiles();
//        for (File f : files) {
//            System.out.println(f.getPath());
//        }
        fileFilter(file);
    }
    public static void fileFilter(File file){
        File[] files = file.listFiles((fl)->fl.isDirectory()||fl.getName().toLowerCase().endsWith(".txt"));
        if(files != null){
        for (File f : files) {
            if(f.isDirectory()){
                fileFilter(f);
            }else {
                System.out.println(f);
            }
        }
        }
    }
}
