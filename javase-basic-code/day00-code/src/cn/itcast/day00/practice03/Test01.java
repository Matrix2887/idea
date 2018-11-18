package cn.itcast.day00.practice03;

import java.util.Arrays;
import java.util.Random;

/*
1.定义长度为10的int类型数组
2.使用随机数(范围20-50之间,包括20和50)为数组进行赋值
3.定义方法change(int[] arr),方法内实现,将数组中的奇数变为原来的2倍
4.打印转换前及转换后的数组,格式如下:
转换前:[21,25,26,28,29,50,48,47,45,44]
转换后:[42,50,26,28,58,50,48,94,90,44]
5.main方法中进行测试
 */
public class Test01 {
    public static void main(String[] args) {
        Random ra = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(31) + 20;
        }
        System.out.print("转换前:");
        System.out.println(Arrays.toString(arr));
        change(arr);

    }
    public static void change(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0){
                arr[i] = arr[i] * 2;
            }
        }
        System.out.print("转换后:");
        System.out.println(Arrays.toString(arr));
    }
}
