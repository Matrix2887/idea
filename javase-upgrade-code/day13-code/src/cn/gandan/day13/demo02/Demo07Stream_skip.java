package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_skip:用于跳过元素
    如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流：
    Stream<T> skip(long n);
        如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
 */
public class Demo07Stream_skip {
    public static void main(String[] args) {
        //获取一个Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("盛开");
        list.add("爆米花");
        list.add("橘子皮");
        list.add("石原里美");
        list.add("盛利");

        Stream<String> stream = list.stream();
        //使用skip方法跳过前3个元素
        Stream<String> skip = stream.skip(3);
        //遍历skip流
        skip.forEach((str)-> System.out.println(str));

    }
}
