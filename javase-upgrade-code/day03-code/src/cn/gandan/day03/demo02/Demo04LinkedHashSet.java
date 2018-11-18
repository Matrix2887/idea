package cn.gandan.day03.demo02;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
    java.util.LinkedHashSet集合 extends HashSet集合
    LinkedHashSet集合特点:
        底层是一个哈希表(数组+链表/红黑树)+链表:多了一条链表(记录元素的存储顺序),保证元素有序
 */
public class Demo04LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("aaa");
        set.add("zzz");
        set.add("zzz");
        set.add("hhh");
        set.add("233");
        System.out.println(set);// [aaa, 233, hhh, zzz] 无序,不允许重复

        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("aaa");
        linked.add("zzz");
        linked.add("zzz");
        linked.add("hhh");
        linked.add("233");
        System.out.println(linked);// [aaa, zzz, hhh, 233] 有序,不允许重复

    }
}
