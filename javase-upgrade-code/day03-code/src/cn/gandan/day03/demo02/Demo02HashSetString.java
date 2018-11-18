package cn.gandan.day03.demo02;

import java.util.HashSet;

/*
    Set集合不允许存储重复元素的原理
    Set集合在调用add方法的时候,add方法会调用元素的hashCode方法和equals方法,判断元素是否重复
    Set集合存储元素不重复的元素
        前提:存储的元素必须重写hashCode方法和equals方法
 */
public class Demo02HashSetString {
    public static void main(String[] args) {
        // 创建HashSet集合对象
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");
        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        set.add("abc");
        System.out.println(set);// [重地, 通话, abc]

    }
}
