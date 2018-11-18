package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_forEach
    void forEach(Consumer<? super T> action);
    该方法接收一个Consumer接口函数，会将每一个流元素交给该函数进行处理。
    Consumer接口是一个消费型的函数式接口,可以传递Lambda表达式,消费数据

    简单记:
        forEach方法,用来遍历流中的数据
        是一个终结方法,遍历之后就不能继续调用Stream流中的其他方法
 */
public class Demo02Stream_forEAch {
    public static void main(String[] args) {
        //获取一个Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("盛利");
        list.add("盛开");
        list.add("爆米花");
        list.add("石原里美");
        list.add("橘子皮");

        //使用Stream流中的方法forEach对Stream流中的数据进行遍历
        /*stream.forEach((String name)->{
            System.out.println(name);
        });*/
        Stream<String> stream = list.stream();
        stream.forEach(str->System.out.println(str));
    }
}
