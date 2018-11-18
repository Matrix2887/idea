package cn.itcast.day00.demo0722;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
键盘录入一个整数，创建一个该长度的数组，为每一个元素赋值为1-10的随机整数，最后打印数组中所有值大于5且为偶数的元素.
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("请输入数组长度");
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(10)+1;
            if(array[i] > 5 && array[i] % 2 == 0){
                System.out.print(array[i] + " ");
            }
        }
    }
}
