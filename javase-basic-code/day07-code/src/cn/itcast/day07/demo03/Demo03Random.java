package cn.itcast.day07.demo03;

import java.util.Random;

/*
题目要求：
根据int变量n的值，来获取随机数字，范围是[1,n]，可以取到1也可以取到n

思路：
1.定义一个int变量num，随意赋值
2.要使用Random:三个步骤，导包、创建、使用
3.如果写10，那么就是0~9，然而想要的是1~10，可以发现：整体加一即可
4.打印随机数字
 */
public class Demo03Random {
    public static void main(String[] args) {
        int num = 10;
        Random r = new Random();


        int result = r.nextInt(num) + 1;
        for (int i = 0; i < 100; i++) {
            // 本来范围是[0,n），整体+1之后变成了[1,n+1),也就是[1,n]
            int result1 = r.nextInt(num) + 1;
            System.out.println(result1);
        }
        System.out.println("================");

        for (int i = 0; i < 100; i++) {
            int num1 = r.nextInt(num);
            System.out.println(num1 + 1);
        }
    }
}
