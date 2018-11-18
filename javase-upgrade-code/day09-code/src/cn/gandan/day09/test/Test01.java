package cn.gandan.day09.test;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/*
根据需求、完成代码
	1.项目根目录下建立文件： user.txt，文件中存放用户名和登录密码，格式：用户名，密码,如：aaa,123；
	2. user.txt文件中初始存放的用户信息有如下：
		jack,123
		rose,123
		tom,123
	3.要求完成如下功能：
	  程序运行时：控制台提示用户输入注册的用户名和密码；
	   验证键盘录入的用户名跟user.txt中已注册的用户名是否重复：
	   是：控制台提示：用户名已存在
	   否：将键盘录入的用户名及密码写入user.txt文件，并在控制台提示：注册成功
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day09-code\\user.txt");
        FileWriter fw = new FileWriter("day09-code\\user.txt",true);
        Properties prop = new Properties();
//============================================================================
        Scanner sc = new Scanner(System.in);
        while(true){
        prop.load(fr);
            System.out.println("用户名");
            String name = sc.nextLine();
            System.out.println("登录密码");
            String code = sc.nextLine();


            Set<String> set = prop.stringPropertyNames();
            int count = 0;
            for (String s : set) {
                if(s.split(",")[0].equals(name)){
                    count++;
                }
            }
            if(count!=0){
                System.out.println("用户名已存在");
            }else{
                fw.write(name + "," + code);
                fw.write("\r\n");
                fw.flush();
                System.out.println("注册成功");
            }
        }
//            fw.close();
//            fr.close();


    }
}
