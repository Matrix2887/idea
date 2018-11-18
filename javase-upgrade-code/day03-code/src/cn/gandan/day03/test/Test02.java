package cn.gandan.day03.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
1.定义一个ArrayList集合，存储以下数字：55 45 65 75 35 25 85
	2.使用集合工具类对其排序。
	3.使用增强for遍历集合元素。
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(55,45,65,75,35,25,85));
        Collections.sort(arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
