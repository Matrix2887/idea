package cn.gandan.day02.test;

import java.util.ArrayList;
import java.util.List;

/*
定义一个集合，存储一些元素。并使用增强for循环遍历输出
 */
public class Test03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
