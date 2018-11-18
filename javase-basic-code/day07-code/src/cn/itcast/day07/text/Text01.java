package cn.itcast.day07.text;

import java.util.Random;
import java.util.Scanner;

public class Text01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int num = 100;
        int result;
        int max;
        int sum = 0;
        int mean;
        System.out.println("输入数组的长度");
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            result = r.nextInt(num) + 1;
            array[i] = result;
        }

        max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }

        for (int i = 0; i < length; i++) {
            sum += array[i];
        }
        mean = sum / length;

        System.out.println("最大值：" + max);
        System.out.println("总和：" + sum);
        System.out.println("平均值：" + mean);
    }
}
