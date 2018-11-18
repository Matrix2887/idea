package cn.gandan.day13.demo02;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流中的常用方法_map:用于类型转换
    如果需要将流中的元素映射到另一个流中，可以使用map方法.
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
    Function中的抽象方法:
        R apply(T t);
 */
public class Demo04Stream_map {
    public static void main(String[] args) {
        //获取一个String类型的Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("7");
        list.add("8");
        list.add("5");

        Stream<String> stream = list.stream();
        Stream<Integer> s = stream.map(str->Integer.parseInt(str));

        s.forEach(i-> System.out.println(i));
        // IllegalStateException
//        stream.forEach(str-> System.out.println(str));

    }
}
