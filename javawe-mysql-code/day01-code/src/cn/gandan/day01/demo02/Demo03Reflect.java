package cn.gandan.day01.demo02;

import cn.gandan.day01.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo03Reflect {
    public static void main(String[] args) throws Exception {
        //获取Person的class对象
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object person = constructor.newInstance("盛利", 16);
        System.out.println(person);
        System.out.println("==============");
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        Object o = personClass.newInstance();
        System.out.println(o);

    }
}
