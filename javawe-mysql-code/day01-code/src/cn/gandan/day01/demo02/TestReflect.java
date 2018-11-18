package cn.gandan.day01.demo02;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflect {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = TestReflect.class.getClassLoader();

        InputStream in = classLoader.getResourceAsStream("pro.properties");
        Properties prop = new Properties();
        prop.load(in);
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        String parameter = prop.getProperty("parameter");

        Class c = Class.forName(className);
        Object o = c.newInstance();
        System.out.println(o);

        if(parameter.equals("null")){
        Method method = c.getMethod(methodName);
        method.invoke(o);
        }else{
        Method method1 = c.getMethod(methodName,String.class);
        method1.invoke(o,parameter);
        }


    }
}
