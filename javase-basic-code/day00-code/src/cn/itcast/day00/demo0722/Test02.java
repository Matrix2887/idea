package cn.itcast.day00.demo0722;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
分析以下需求，并用代码实现
	1.提示用户输入10个整数，存入到int数组中；根据以下要求实现相关功能
	2.提示用户输入一个数字作为数组索引，查找数组中该索引对应的元素，
		（需要判断输入的数字是否在0-9之间包含临界值，如果该数字不符合要求则随机生成一个符合要求的索引）
	3.将2中得到的索引对应的元素的左右两边元素进行互换，若对应的元素是第一个或最后一个则不做任何操作

 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("请输入数组长度");
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.println("请输入第" + (i+1) + "整数");
            int num = sc.nextInt();
            array[i] = num;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("请输入索引");
        int index = sc.nextInt();
        if(index >= 0 && index <= array.length-1){
            System.out.println(array[index]);
            if(index != 0 && index != array.length-1){
                int temp = array[index - 1];
                array[index - 1] = array[index + 1];
                array[index + 1] = temp;
            }
        }else{
            index = r.nextInt(array.length);
            System.out.println("索引错误以自动生成" + index + "索引");
            System.out.println("对应元素是" + array[index]);
            if(index != 0 && index != array.length-1){
                int temp = array[index - 1];
                array[index - 1] = array[index + 1];
                array[index + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
