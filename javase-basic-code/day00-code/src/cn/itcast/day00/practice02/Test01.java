package cn.itcast.day00.practice02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
(1)创建长度为10的int类型数组,并使用随机数(范围2-50包括2和50)为数组赋值
(2)定义findNum方法,传递数组及键盘录入的数据,判断该数据在数组中是否存在,
如果存在,则打印数字在数组中最后一次出现的位置
如果不存在,则打印"不存在",并且不存在只需要提示一次
(3)定义方法,统计数组中小于平均值元素的个数,将结果返回并进行输出
 */
public class Test01 {
    public static void main(String[] args) {
        Random ra = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(49) + 2;
        }
        System.out.println(Arrays.toString(arr));
        findNum(arr);
        int count = number(arr);
        System.out.println("小于平均值元素的个数为:" + count);
    }
    public static void findNum(int[] arr){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int num = sc.nextInt();
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == num){
                System.out.println("该数字在数组中最后一次出现的位置是:" + i);
                count++;
                break;
            }
        }
        if(count == 0){
            System.out.println("该数不存在");
        }
    }
    public static int number(int[] arr){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = sum / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < avg){
                count++;
            }
        }
        return count;
    }
}
