package cn.itcast.day00.demo0722;

import java.util.Random;

/*
随机产生5个范围是[1,100]的整数,把这些数字中所有个位或十位为3的数字打印出来
 */
public class Test01 {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int num = r.nextInt(100)+1;
            if (num % 10 == 3 || num / 10 % 10 == 3){
                System.out.println(num);
            }
        }
    }
}
