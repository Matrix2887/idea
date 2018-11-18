package cn.itcast.day08.test;

import java.util.ArrayList;
import java.util.Scanner;

/*
	1.键盘录入一个大字符串,再录入一个小字符串
	2.统计小字符串在大字符串中出现的次数
	3.代码运行打印格式:
		请输入大字符串:woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma
		请输入小字符串:heima

		控制台输出:共出现3次
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入大字符串");
        String bigStr = new String(sc.next());
        bigStr = "woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma";
        System.out.println("请输入小字符串");
        String littleStr = new String(sc.next());
        littleStr = "heima";
        int count = 0;
        String[] array = bigStr.split(",");
        for (int i = 0; i < array.length; i++) {
            if(array[i].indexOf(littleStr) > -1){
                count++;
            }
        }
        System.out.println("共出现" + count + "次");
        System.out.println("================");
        System.out.println("共出现" + result(bigStr,littleStr) + "次");
    }
    public static int result(String bigStr,String littleStr){
        String[] num = bigStr.split(littleStr);
        return num.length - 1;
    }
}

