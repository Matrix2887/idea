package cn.itcast.day00.practice01;

import java.util.Scanner;

/*
1.键盘一个大于100的整数，打印1-该数字之间(包括1和该数字)能同时被3和5整除的数字及数字的个数，
要求：每行打印5个满足条件的数字，数字之间使用空格进行分隔
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
        System.out.println("输入数字");
        int num = sc.nextInt();
        if(num > 100){
        for (int i = 1,count = 0; i <= num; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                System.out.print(i + "\t");
                count++;
                if(count % 5 == 0){
                    System.out.println();
                }
            }
        }
        break;
        }else{
            System.out.println("嘿,你个吊毛");
        }
        }
    }
}
