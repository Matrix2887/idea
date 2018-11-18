package cn.gandan.day08.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/*
        练习File类的常用方法
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        /*
            public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
            public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
            public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
            public String getAbsolutePath() ：返回此File的绝对路径名字符串。
            public String getPath() ：将此File转换为路径名字符串。
            public String getName() ：返回由此File表示的文件或目录的名称。
            public long length() ：返回由此File表示的文件的长度。
            public boolean exists() ：此File表示的文件或目录是否实际存在。
            public boolean isDirectory() ：此File表示的是否为目录。
            public boolean isFile() ：此File表示的是否为文件。
            public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
            public boolean delete() ：删除由此File表示的文件或目录。
            public boolean mkdir() ：创建由此File表示的目录。
            public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
            public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
            public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
         */


        /*
            public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
            public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
            public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
         */
        File f1 = new File("D:\\A\\javase-upgrade-code\\day08-code\\1");
        System.out.println(f1);
        File f2 = new File("D:\\A\\javase-upgrade-code\\day08-code\\", "2");
        System.out.println(f2);
        File f = new File("D:\\A\\javase-upgrade-code\\day08-code\\src\\cn\\gandan\\day08");
        File f3 = new File(f, "\\3\\4\\5");
        System.out.println(f3);
        File f4 = new File("4");
        System.out.println("=================================================================================");
        /*
            public String getAbsolutePath() ：返回此File的绝对路径名字符串。
            public String getPath() ：将此File转换为路径名字符串。
            public String getName() ：返回由此File表示的文件或目录的名称。
            public long length() ：返回由此File表示的文件的长度。
         */
        String ap1 = f4.getAbsolutePath();
        System.out.println(ap1);
        String p1 = f1.getPath();
        System.out.println(p1);
        String n1 = f2.getName();
        System.out.println(n1);
        File f5 = new File("D:\\A\\javase-upgrade-code\\day08-code\\day08-code.iml");
        long l1 = f5.length();
        System.out.println(l1);
        System.out.println("=================================================================================");
        /*
            public boolean exists() ：此File表示的文件或目录是否实际存在。
            public boolean isDirectory() ：此File表示的是否为目录。
            public boolean isFile() ：此File表示的是否为文件。
         */
        boolean e1 = f1.exists();
        System.out.println("e1-->" + e1);
        boolean e2 = f.exists();
        System.out.println("e2-->" + e2);
        boolean d1 = f5.isDirectory();
        System.out.println("d1-->" + d1);
        boolean d2 = f.isDirectory();
        System.out.println("d2-->" + d2);
        boolean d3 = f5.isFile();
        System.out.println("d3-->" + d3);
        boolean d4 = f.isFile();
        System.out.println("d4-->" + d4);
        System.out.println("=================================================================================");
        /*
            public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
            public boolean delete() ：删除由此File表示的文件或目录。
         */
        boolean b1 = f1.createNewFile();
        System.out.println("b1-->" + b1);
        boolean b2 = f1.delete();
        System.out.println("b2-->" + b2);
        System.out.println("=================================================================================");
        /*
            public boolean mkdir() ：创建由此File表示的目录。
            public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
         */
        boolean m1 = f2.mkdir();
        System.out.println("m1-->" + m1);
        boolean b3 = f2.delete();
        System.out.println("b3-->" + b3);
//        boolean m2 = f3.mkdirs();
//        System.out.println("m2-->" + m2);
//        boolean b4 = f3.delete();
//        System.out.println("b4-->" + b4);

        System.out.println("=================================================================================");
        /*
            public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
            public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
         */
        String[] list = f.list();
        System.out.println(Arrays.toString(list));
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        System.out.println("=================================================================================");
        getFile(f);
        System.out.println("=================================================================================");
        getFileJava(f);
        System.out.println("=================================================================================");
        getFileFilter(f);


    }
    public static void getFile(File f){
        System.out.println(f);
        File[] files = f.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                getFile(file);
            }else{
                System.out.println(file);
            }
        }
    }
    public static void getFileJava(File f){
        File[] files = f.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                getFileJava(file);
            }else if(file.getName().toLowerCase().endsWith(".java")){
                System.out.println(">>>" + file + "<<<");
            }
        }
    }

    public static void getFileFilter(File f){
        File[] files = f.listFiles((fi)->fi.isDirectory()||fi.getName().toLowerCase().endsWith(".java"));
        for (File file : files) {
            if(file.isDirectory()){
                getFileFilter(file);
            }else{
                System.out.println("<<<" + file + ">>>");
            }
        }
    }
}
