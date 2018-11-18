package cn.gandan.day03.demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    java.util.list 接口 extend Collection接口
    List接口的特点:
        1.有序的集合,存储元素和取出元素的顺序是一致的
        2.有索引,包含了一些带索引的方法
        3.允许存储重复的元素

    List接口带索引的方法(特有)
        public void add(int index,E element):将指定的元素,添加到该集合中指定位置上
        public E get(int index):返回集合中指定位置的元素
        public E remove(int index):移除列表中指定位置的元素,返回的是被移除的元素
        public E set(int index,E element):用指定元素替换集合中指定位置的元素,返回值是更新前的元素
    注意:
        操作索引的时候,一定要防止索引越界异常
        IndexOutOfBoundsException:索引越界异常,集合会报
        ArrayIndexOutOfBoundsException:数组索引越界异常,集合会报
        StringIndexOutOfBoundsException:字符串索引越界异常,集合会报
 */
public class Demo01List {
    public static void main(String[] args) {
        // 创建一个list集合对象,多态
        List<String> list = new ArrayList<>();
        // 使用add方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        // 打印集合
        // 重写toString方法
        System.out.println(list);// [a, b, c, a]

        // public void add(int index,E element):将指定的元素,添加到该集合中指定位置上
        // 在b和c之间添加一个guo
        list.add(2,"guo");
        System.out.println(list);// [a, b, guo, c, a]

        // public E remove(int index):移除列表中指定位置的元素,返回的是被移除的元素
        // 移除c元素
        String removeE = list.remove(3);
        System.out.println(removeE);// c
        System.out.println(list);// [a, b, guo, a]

        // public E set(int index,E element):用指定元素替换集合中指定位置的元素,返回值是更新前的元素
        // 把最后一个a替换为A
        String setE = list.set(3, "A");
        System.out.println(setE);// a
        System.out.println(list);// [a, b, guo, A]

        // list集合遍历有三种方式
        // 使用普通的for循环
        for (int i = 0; i < list.size(); i++) {
            // public E get(int index):返回集合中指定位置的元素
            System.out.println(list.get(i));
        }

        System.out.println("=========");
        // 使用迭代器
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=========");
        // 使用增强for
        for (String s : list) {
            System.out.println(s);
        }
//        String s = list.get(5);// IndexOutOfBoundsException

    }
}
