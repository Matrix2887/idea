package cn.gandan.day01.demo02;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = Test.class.getClassLoader();
        InputStream res = classLoader.getResourceAsStream("pro.properties");


        Properties prop = new Properties();
        prop.load(res);
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);
    }
}
