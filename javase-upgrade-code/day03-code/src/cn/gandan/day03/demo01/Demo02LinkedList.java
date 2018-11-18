package cn.gandan.day03.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/*
    java.util.LinkedList集合 implements list接口
    LinkedList集合的特点:
        1.底层是一个链表结构:查询慢,增删快
        2.里面包含了大量操作首尾元素的方法
        注意:使用LinkedList集合特有的方法,不能使用多态

        public void addFirst(E e):将指定元素插入此列表的开头
        public void addLast(E e):将指定元素添加到此列表的结尾
        public void push(E e):将元素推入此列表所表示的堆栈

        public E getFirst():返回此列表的第一个元素
        public E getLast():返回此列表的最后一个元素

        public E removeFirst():移除并返回此列表的第一个元素
        public E removeLast():移除并返回此列表的最后一个元素
        public E pop():从此列表所表示的堆栈处弹出一个元素

        public boolean isEmpty():如果列表不包含元素,则返回true
 */
public class Demo02LinkedList {
    public static void main(String[] args) {
        addPush();
        getFaL();
        removePop();
    }

    /*
        E removeFirst():移除并返回此列表的第一个元素
        public E removeLast():移除并返回此列表的最后一个元素
        public E pop():从此列表所表示的堆栈处弹出一个元素,相当于removeFist
     */
    private static void removePop() {
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        // 使用add方法往集合中添加元素
        linked.addLast("a");
        linked.addLast("b");
        linked.addLast("c");
        System.out.println(linked);

//        String first = linked.removeFirst();
        String first = linked.pop();
        System.out.println(first);// a
        String last = linked.removeLast();
        System.out.println(last);// c
        System.out.println(linked);// [b]
    }

    /*
        public void addFirst(E e):将指定元素插入此列表的开头
        public void addLast(E e):将指定元素添加到此列表的结尾
        public void push(E e):将元素推入此列表所表示的堆栈
     */
    private static void addPush() {
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        // 使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);// [a, b, c]

        // public void addFirst(E e):将指定元素插入此列表的开头
        linked.addFirst("1");
        System.out.println(linked);// [1, a, b, c]
        linked.push("0");
        System.out.println(linked);// [0, 1, a, b, c]

        // public void addLast(E e):将指定元素添加到此列表的结尾
        // 注意:此方法等效于add()
        linked.addLast("L");
        System.out.println(linked);// [0, 1, a, b, c, L]
    }

    /*
        public E getFirst():返回此列表的第一个元素
        public E getLast():返回此列表的最后一个元素
     */
    public static void getFaL() {
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        // 使用add方法往集合中添加元素
        linked.addLast("a");
        linked.addLast("b");
        linked.addLast("c");


//        linked.clear();// 清空集合中的元素 NoSuchElementException

        // public boolean isEmpty():如果列表不包含元素,则返回true
        if (!linked.isEmpty()) {

            String first = linked.getFirst();
            System.out.println(first);// a
            String last = linked.getLast();
            System.out.println(last);// c
        }
    }
}
