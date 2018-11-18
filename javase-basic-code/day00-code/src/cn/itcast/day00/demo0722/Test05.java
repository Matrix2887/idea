package cn.itcast.day00.demo0722;

import java.util.Random;

/*
将数字1-10保存到一个长度为10的一维数组中
定义一个新数组,长度为3,取出原来数组中随机三个元素(不考虑是否重复)
给新数组的元素赋值
求新数组所有元素的和
 */
public class Test05 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arrayNun = {1,2,3,4,5,6,7,8,9,10};
        int[] num = new int[3];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] = arrayNun[r.nextInt(10)];
            sum += num[i];
        }
        System.out.println(sum);
    }
}
