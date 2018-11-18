package cn.gandan.day04.demo04;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    JDK9的新特性:
        List接口,Set接口,Map接口:里面增加了一个静态的方法of,可以给集合一次性添加多个元素
        static <E> List<E> of (E...elements)
        使用前提:
            当集合中存储的元素的个数已经确定了,不在改变时使用
    注意:
        1.of方法只适用于List接口,Set接口,Map接口,不适用于接口的实现类
        2.of方法的返回值是一个不能改变的集合,集合不能再使用add,put方法添加元素,会抛出异常
        3.Set接口和Map接口在调用of方法的时候,不能有重复的元素,否则会抛出异常

 */
public class Demo01JDK9 {
    public static void main(String[] args) {
        List<String> list = List.of("a","b","c","d","e");
        System.out.println(list);
        // UnsupportedOperationException不支持操作异常
//        list.add("w");


        // IllegalArgumentException 非法操作异常 有重复的元素
//        Set<String> set = Set.of("a", "b", "c", "a");
        Set<String> set = Set.of("a", "b", "c");
        System.out.println(set);
        // UnsupportedOperationException不支持操作异常
//        set.add("v");

        // IllegalArgumentException 非法操作异常 有重复的元素
//        Map<String, Integer> map = Map.of("艾登.皮尔斯", 38, "玛丽.皮尔斯", 28,"艾登.皮尔斯", 38);
        Map<String, Integer> map = Map.of("艾登.皮尔斯", 38, "玛丽.皮尔斯", 28);
        System.out.println(map);// {玛丽.皮尔斯=28, 艾登.皮尔斯=38}
        // UnsupportedOperationException不支持操作异常
//        map.put("富兰克林",26);
    }
}
