package cn.gandan.day01.demo01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,3));

        Class aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,"盛利");
        System.out.println(list);
        Object a = list.get(4);
        System.out.println(a);
    }
}
