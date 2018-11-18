package cn.gandan.test.test0809;

import java.util.*;

/*
"第一题：分析以下需求，并用代码实现
"	1.生成10个1至100之间的随机整数(不能重复)，存入一个List集合
"	2.然后利用迭代器和增强for循环分别遍历集合元素并输出
"	3.如：15 18 20 40 46 60 65 70 75 91

 */
public class Test01 {
    public static void main(String[] args) {
    Random ra = new Random();
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    while(set.size()<10){
        set.add(ra.nextInt(99) + 1);
    }
        Iterator<Integer> it = set.iterator();
    while(it.hasNext()){
        int count = it.next();
        System.out.print(count + " ");
        list.add(count);
    }
        System.out.println();
        System.out.println("=============================");
    Collections.sort(list);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
}
