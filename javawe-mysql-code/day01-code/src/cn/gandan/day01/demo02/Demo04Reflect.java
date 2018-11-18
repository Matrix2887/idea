package cn.gandan.day01.demo02;

import cn.gandan.day01.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo04Reflect {
    public static void main(String[] args) throws Exception {
        //获取Person的class对象
        Class personClass = Person.class;

        Method love_method = personClass.getMethod("love");
        // 执行方法
        Person p = new Person();
        love_method.invoke(p);

        Method love_method2 = personClass.getMethod("love", String.class);
        love_method2.invoke(p,"我");
        System.out.println("===================");
        // 获取所有
        Method[] methods = personClass.getMethods();
        // 会继承父类的方法
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        String name = personClass.getName();
        System.out.println(name);


    }
}
