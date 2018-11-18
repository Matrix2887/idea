package cn.gandan.day02.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
    java.util.Collection接口
        所有单列集合的最顶层的接口,里面定义了所有单列集合共性的方法
        任意的单列集合都可以使用Collection接口中的方法

    共性的方法:
    public boolean add(E e):把给定的对象添加到当前集合中
    public void clear():清空集合中所有的元素
    public boolean remove(E e):把给定的对象在当前集合中删除
    public boolean contains(E e):判断当前集合中是否包含给定的对象
    public boolean isEmpty():判断当前集合是否为空
    public int size():返回集合中元素的个数
    public Object[] toArray():把集合中的元素,存储到数组中

 */
public class Demo01Collection {
    public static void main(String[] args) {
        // 创建集合对象,可以使用多态
        Collection<String> coll = new ArrayList<>();
//        Collection<String> coll = new HashSet<>();
        System.out.println(coll);// 重写了toString方法  []

        /*
            public boolean add(E e):把给定的对象添加到当前集合中
            返回值是一个boolean值,一般都返回true,所以可以不用接收
         */
        boolean b = coll.add("艾登.皮尔斯");
        System.out.println("b:" + b);// b:true
        System.out.println(coll);// [艾登.皮尔斯]
        coll.add("玛丽.皮尔斯");
        coll.add("富兰克林");
        coll.add("富兰克林");
        coll.add("特朗普");
        coll.add("特朗普");
        System.out.println(coll);// [艾登.皮尔斯, 玛丽.皮尔斯, 富兰克林, 特兰普]

        /*
            public boolean remove(E e):把给定的对象在当前集合中删除
            返回值是一个boolean值,集合中存在元素,删除元素返回true
                                 集合中不存在元素,删除失败返回false
         */
        boolean b2 = coll.remove("特朗普");
        System.out.println("b2:" + b2);// b2:true
        boolean b3 = coll.remove("奥巴马");
        System.out.println("b3:" + b3);// b3:false
        System.out.println(coll);// [艾登.皮尔斯, 玛丽.皮尔斯, 富兰克林]

        // public boolean contains(E e):判断当前集合中是否包含给定的对象
        // 包含返回true     不包含返回false
        boolean b4 = coll.contains("富兰克林");
        System.out.println("b4:" + b4);// b4:true
        boolean b5 = coll.contains("特朗普");
        System.out.println("b5:" + b5);// b5:false

        // public boolean isEmpty():判断当前集合是否为空.集合为空发挥true.集合不为空返回false.
        boolean t = coll.isEmpty();
        System.out.println("t:" + t);// t:false

        // public int size():返回集合中元素的个数
        int n = coll.size();
        System.out.println("n:" + n);// n:3

        // public Object[] toArray():把集合中的元素,存储到数组中
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // public void clear():清空集合中所有的元素,但是不删除集合,集合还存
        coll.clear();
        System.out.println(coll);// []
        System.out.println(coll.isEmpty());// true

        // public int size():返回集合中元素的个数
        int m = coll.size();
        System.out.println("m:" + m);// m:0

    }
}
