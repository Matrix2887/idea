package cn.gandan.day01.demo03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Class cls = c.getClass();
        Method[] methods = cls.getMethods();

        int count = 0;// 次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                   count++;
                   bw.write(method.getName() + "方法出异常");
                   bw.newLine();
                   bw.write("异常名称" + e.getCause().getClass().getSimpleName());
                   bw.newLine();
                   bw.write("异常的原因" + e.getCause().getMessage());
                   bw.newLine();
                   bw.write("===================================");
                   bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现"+count+"异常");
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
