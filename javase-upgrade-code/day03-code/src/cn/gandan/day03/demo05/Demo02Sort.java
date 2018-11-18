package cn.gandan.day03.demo05;

import java.util.ArrayList;
import java.util.Collections;

/*
    java.utils.Collections是集合工具类,用来对集合进行操作.部分方法如下:
    public static<T> void sort(List<T> list):将集合中元素按照默认规则排序

    注意:
        sort(List<T> list)使用前提
        被排序的集合里面存储的元素,必须实现Comparable,重写接口中的方法compareTo定义排序的规则

    Comparable接口的排序规则:
        自己(this()) - 参数:升序
 */
public class Demo02Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,2);
        System.out.println(list);// [1, 3, 2]

        // public static<T> void sort(List<T> list):将集合中元素按照默认规则排序
        Collections.sort(list);// 默认是升序
        System.out.println(list);// [1, 2, 3]

        ArrayList<String> str = new ArrayList<>();
        Collections.addAll(str,"a","c","b");
        System.out.println(str);// [a, c, b]
        Collections.sort(str);
        System.out.println(str);// [a, b, c]

        ArrayList<Person> person = new ArrayList<>();
        person.add(new Person("IQ",35));
        person.add(new Person("ASH",25));
        person.add(new Person("Ying",28));
        System.out.println(person);// [Person{name='IQ', age=35}, Person{name='ASH', age=25}, Person{name='YING', age=28}]

        Collections.sort(person);
        System.out.println(person);// [Person{name='ASH', age=25}, Person{name='Ying', age=28}, Person{name='IQ', age=35}]

    }
}
