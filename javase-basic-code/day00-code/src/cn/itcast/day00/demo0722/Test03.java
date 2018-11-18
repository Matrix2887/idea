package cn.itcast.day00.demo0722;

import java.util.Random;
import java.util.Scanner;

/*
分析以下需求，并用代码实现
	1.键盘录入班级人数
	2.根据录入的班级人数创建数组
	3.利用随机数产生0-100的成绩(包含0和100)
	4.要求:
		(1)打印该班级的不及格人数
		(2)打印该班级的平均分
		(3)演示格式如下:
			请输入班级人数:
			键盘录入:100
			控制台输出:
				不及格人数:19
				班级平均分:87
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("请输入班级人数");
        int num = sc.nextInt();
        if (num <= 0){
            System.out.println("这个班级个个都是火星人");
        }else{      int[] score =new int[num];
            for (int i = 0; i < num; i++) {
                score[i] = r.nextInt(101);
            }
            int failPeople = fail(score);
            System.out.println("不及格人数为：" + failPeople);
            int sum = totalPoints(score);
            System.out.println("班级总分数：" + sum);
            double meanValue = meanValue(score);
            System.out.println("班级平均分：" + meanValue);}
    }
    public static int fail(int[] score){
        int count = 0;
        for (int i = 0 ; i < score.length; i++) {
            if (score[i] < 60 && score[i] != 0){
                count++;
            }
        }
        return count;
    }
    public static int totalPoints(int[] score){
        int sum1 = score[0];
        for (int i = 1; i < score.length; i++) {
            sum1 = sum1 + score[i];
        }
        return  sum1;
    }
    public static double meanValue(int[] score){
        double sum1 = score[0];
        double numOfPeople = score.length;
        for (int i = 1; i < score.length; i++) {
            sum1 = sum1 + score[i];
        }
        double meanValue = sum1 / numOfPeople;
        return meanValue;
    }
}
