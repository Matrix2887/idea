package cn.itcast.day07.demo05;

import java.util.ArrayList;
import java.util.Random;

/*
题目：
生成6个1~33之间的随机整数，添加刀集合，并遍历集合

思路：
1.需要存储6个数字，创建一个集合，<Integer>
2.产生随机数，需要用到Random
3.用循环6次，来产生6个随机数字：for循环
4.循环内调用r.nextInt(int n),参数是33、0~32，整体+1才是1~33
5.把数字添加到集合中：add
6.遍历集合：for、size、get
 */
public class Demo01ArrayListRandom {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> array = new ArrayList<>();
        Random r = new Random();
        int num = 33;
        for (int i = 0; i < 6; i++) {
            int result = r.nextInt(num)+1;
            list.add(result);

        }
        for (int i = 0; i < 6; i++) {
            array.add(r.nextInt(100)+1);
        }
        System.out.println(array);
        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
