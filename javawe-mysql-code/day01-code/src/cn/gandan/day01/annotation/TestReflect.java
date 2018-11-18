package cn.gandan.day01.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

@Pro(className = "cn.gandan.day01.annotation.Name",methodName = "show")
public class TestReflect {
    public static void main(String[] args) throws Exception {
        // 解析注解
        // 获取该类的字节码文件对象
        Class<TestReflect> refletTestClass = TestReflect.class;
        // 获取注解对象
        // 其实就是在内存中去生成了一个该注解接口的子类实现对象
        Pro an = refletTestClass.getAnnotation(Pro.class);
        // 调用抽象方法
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className + "  " + methodName);

        Class c = Class.forName(className);
        Object o = c.newInstance();
        System.out.println(o);
        Method method = c.getMethod(methodName);
        method.invoke(o);



    }
}
