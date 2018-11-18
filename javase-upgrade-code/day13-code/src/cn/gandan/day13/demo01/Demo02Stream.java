package cn.gandan.day13.demo01;

import java.util.ArrayList;

/*
    java.util.stream.Stream<T>是Java 8新加入的最常用的流接口。（这并不是一个函数式接口。）
    获取一个流非常简单，有以下几种常用的方式：
        - 所有的Collection集合都可以通过stream默认方法获取流；
            default Stream<E> stream​()
        - Stream接口的静态方法of可以获取数组对应的流。
            static <T> Stream<T> of​(T... values)
            参数是一个可变参数,那么我们就可以传递一个数组
 */
public class Demo02Stream {
    public static void main(String[] args) {

        //创建一个List集合,存储姓名
        ArrayList<String> list = new ArrayList<>();
        list.add("盛利");
        list.add("盛开");
        list.add("爆米花");
        list.add("石原里美");
        list.add("橘子皮");

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        //遍历listB集合
        list.stream()
                .filter(name->name.startsWith("盛"))
                .filter(name->name.length()==2)
                .forEach(name-> System.out.println(name));

    }
}
