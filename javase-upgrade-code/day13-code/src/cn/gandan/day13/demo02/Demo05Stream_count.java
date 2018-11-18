package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_count:用于统计Stream流中元素的个数
    long count();
    count方法是一个终结方法,返回值是一个long类型的整数
    所以不能再继续调用Stream流中的其他方法了
 */
public class Demo05Stream_count {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("盛利");
        list.add("盛开");
        list.add("爆米花");
        list.add("石原");
        list.add("橘子皮");

        Stream<String> stream = list.stream();
        long count = stream.count();
        System.out.println(count);

    }
}
