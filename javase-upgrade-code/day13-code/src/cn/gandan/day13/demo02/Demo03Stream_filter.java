package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_filter:用于对Stream流中的数据进行过滤
    Stream<T> filter(Predicate<? super T> predicate);
    filter方法的参数Predicate是一个函数式接口,所以可以传递Lambda表达式,对数据进行过滤
    Predicate中的抽象方法:
        boolean test(T t);
 */
public class Demo03Stream_filter {
    public static void main(String[] args) {
        //创建一个Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("盛利");
        list.add("盛开");
        list.add("爆米花");
        list.add("石原");
        list.add("橘子皮");

        //对Stream流中的元素进行过滤,只要盛利
        Stream<String> stream = list.stream();
        Stream<String> s = stream.filter((str)->{return str.startsWith("盛利");});

        s.forEach(str-> System.out.println(str));
        // IllegalStateException
//        stream.forEach(str-> System.out.println(str));

    }
}
