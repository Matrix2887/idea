package cn.itcast.day07.demo03;

import java.util.Random;
import java.util.Scanner;

/*
题目：
用代码模拟猜数字的小游戏

思路：
1.首先需要产生一个随机数字，并且一旦产生不在变化。用Random的nextInt方法
2.需要键盘输入，所以用到了Scanner
3.获取键盘输入的数字，用Scanner当中的nextInt方法
4.已经得到了两个数字，判断（if）一下:
    如果太大了，提示太大，并且重试；
    如果太小了，提示太小，并且重试；
    如果猜中了，游戏结束。
5.重试就是再来一次，循环次数不确定，用while(true).
 */
public class Demo04RandomGame {
    public static void main(String[] args) {
        int num = 100;
        Random r = new Random();
        int result = r.nextInt(num) + 1;
        Scanner sc = new Scanner(System.in);
//        int b = result + 1;
        System.out.println("welcome 来到猜数字游戏，你一共有10次机会");
    /*    while(b != result){
            System.out.println("请输入你猜的数字");
            int a = sc.nextInt();
            if (a > result){
                System.out.println("太大了，请重试");
            }else if (a < result){
                System.out.println("太小了，请重试");
            }else if (a == result){
                System.out.println("恭喜你猜正确" + result );
            }
            b = a;
        }
        while (true){
            System.out.println("请输入你猜的数字");
            int c = sc.nextInt();
            if (c > result){
                System.out.println("太大了，请重试");
            }else if (c < result){
                System.out.println("太小了，请重试");
            }else if (c == result){
                System.out.println("恭喜你猜正确" + result );
                break;
            }
        }*/


        for (int i = 1; i <= 10; i++) {
            if (i <= 9) {
                System.out.println("第" + i + "次" + "  请输入你猜1~100之间的数字");
                int d = sc.nextInt();
                if (d >= 1 && d <= 100) {
                    if (d > result && i <= 10) {
                        System.out.println("太大了，请重试");
                    } else if (d < result && i <= 10) {
                        System.out.println("太小了，请重试");
                    } else if (d == result && i <= 10) {
                        System.out.println("恭喜你猜中" + result);
                        break;
                    }
                } else {
                    System.out.println("你输入的数字超出天际，并且浪费了一次机会");
                }
            } else if (i == 10) {
                System.out.println("第" + i + "次" + "  请输入你猜1~100之间的数字");
                int d = sc.nextInt();
                if (d != result) {
                    System.out.println("游戏结束，很遗憾，猜测失败。正确结果是：" + result);
                    break;
                } else {
                    System.out.println("真是惊险，恭喜你在最后一刻猜中了。正确结果是" + result);
                    break;
                }
            }
        }
    }
}
