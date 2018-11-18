package cn.gandan.day01.demo02;

import cn.gandan.day01.domain.Person;

import java.lang.reflect.Field;

public class Demo02Reflect {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取Person的class对象
        Class personClass = Person.class;
        // 获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=================");
        Field a = personClass.getField("a");
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        a.set(p,"盛利");
        Object o = a.get(p);
        System.out.println(o);
        System.out.println(p);
        System.out.println("=================");
        // 获取所有的成员变量,不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        // 获取单个
        Field d = personClass.getDeclaredField("d");
        // 忽略访问权限修饰符的安全检查
        d.setAccessible(true);// 暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
