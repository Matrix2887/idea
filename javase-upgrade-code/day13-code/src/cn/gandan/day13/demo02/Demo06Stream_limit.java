package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_limit:用于截取流中的元素
    limit方法可以对流进行截取，只取用前n个。方法签名：
    Stream<T> limit(long maxSize);
        参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作
    limit方法是一个延迟方法,只是对流中的元素进行截取,返回的是一个新的流,所以可以继续调用Stream流中的其他方法
 */
public class Demo06Stream_limit {
    public static void main(String[] args) {
        //获取一个Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("盛利");
        list.add("石原里美");
        list.add("盛开");
        list.add("爆米花");
        list.add("橘子皮");

        Stream<String> stream = list.stream();
        //使用limit对Stream流中的元素进行截取,只要前2个元素
        Stream<String> limit = stream.limit(2);
        limit.forEach((str)-> System.out.println(str));

    }
}
