package cn.gandan.day01.demo06;

import java.util.ArrayList;

/*
    自动装箱与自动拆箱:基本类型的数据和包装类
 */
public class Demo02Integer {
    public static void main(String[] args) {
        /*
            自动装箱:直接把int类型的整数赋值包装类
            Integer i = 1; 就相当于 Integer i = new Integer(1);
         */
        Integer i = 1;
        /*
            自动拆箱:i是包装类,无法直接参与运算,可以自动转换为基本数据类型,在进行计算
            i+2;就相当于 i.intVale() + 2
            i = i.intVale() + 2 = 3又是一个自动装箱
         */
        i = i + 2;
        ArrayList<Integer> list = new ArrayList<>();
        /*
            ArrayList集合无法直接存储整数,可以存储Integer包装类
         */
        list.add(1);// -->自动装箱 list.add(new Integer(1));

        int a = list.get(0);// -->自动拆箱 list.get(0).intValue();
    }
}
