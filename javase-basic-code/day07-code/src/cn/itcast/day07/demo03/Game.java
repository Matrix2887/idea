package cn.itcast.day07.demo03;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        int num = 100;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String s = "y";
        System.out.println("welcome 来到猜数字游戏，你一共有10次机会");
        while (true) {
            char over = s.charAt(0);
            if (over != 'n') {
                int result = r.nextInt(num) + 1;
            for (int i = 1; i <= 10; i++) {
                if (i <= 9) {
                    System.out.println("第" + i + "次" + "  请输入你猜1~100之间的数字");
                    int a = sc.nextInt();
                    if (a >= 1 && a <= 100) {
                        if (a > result && i <= 10) {
                            System.out.println("太大了，请重试");
                        } else if (a < result && i <= 10) {
                            System.out.println("太小了，请重试");
                        } else if (a == result && i <= 10) {
                            System.out.println("恭喜你猜中" + result);
                            i = 10;
                            option();
                            s = sc.next();
                        }
                }else {
                        System.out.println("你输入的数字超出天际，并且浪费了一次机会");
                    }
                } else if (i == 10) {
                    System.out.println("第" + i + "次" + "  请输入你猜1~100之间的数字");
                    int d = sc.nextInt();
                    if (d != result) {
                        System.out.println("游戏结束，很遗憾，猜测失败。正确结果是：" + result);
                        option();
                        s = sc.next();
                    } else {
                        System.out.println("真是惊险，恭喜你在最后一刻猜中了。正确结果是" + result);
                        option();
                        s = sc.next();
                    }
                }
            }
        }else if (over == 'n') {
                break;
            }
    }
    }
    public static void option(){
        System.out.println("游戏结束!!");
        System.out.println("输入y开始新一轮游戏,输入n关闭游戏");
    }
}
