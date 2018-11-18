package cn.gandan.test.test0809;

import java.util.*;

/*
"第五题：分析以下需求，并用代码实现
"	1.定义一个长度为10的int数组,并存入10个int类型的数据,其中有一些数据是重复的
"	2.利用集合的知识对数组进行去重,产生新数组,不能改变数组中原来数字的大小顺序
"	3.打印新数组中的内容
 */
public class Test05 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,13,5,1,2,3,9,5,12,4,2,3,4,5};
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (Integer j : set) {
            list.add(j);
        }

        Integer[] i = new Integer[0];
        Integer[] j = list.toArray(i);
        System.out.println(Arrays.toString(j));

    }
}
