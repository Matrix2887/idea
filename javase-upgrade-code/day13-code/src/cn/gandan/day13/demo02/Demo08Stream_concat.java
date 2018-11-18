package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_concat:用于把流组合到一起
    如果有两个流，希望合并成为一个流，那么可以使用Stream接口的静态方法concat
    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 */
public class Demo08Stream_concat {
    public static void main(String[] args) {
        //创建一个Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("盛开");
        list.add("爆米花");
        list.add("橘子皮");
        list.add("石原里美");
        list.add("盛利");

        Stream<String> s = Stream.of("1", "2", "3");
        //获取一个Stream流
        Stream<String> stream = list.stream();

        //把以上两个流组合为一个流
        Stream<String> concat = Stream.concat(stream, s);
        //遍历concat流
        concat.forEach((str)-> System.out.println(str));

    }
}
