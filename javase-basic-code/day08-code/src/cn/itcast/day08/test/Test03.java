package cn.itcast.day08.test;

import java.util.Random;

/*
定义String getStr()方法
		功能描述：
			获取长度为5的随机字符串
			字符串由随机的4个大写英文字母和1个0-9之间(包含0和9)的整数组成
			英文字母和数字的顺序是随机的
 */
public class Test03 {
    public static void main(String[] args) {
        while (true){
        String a = getStr(5);
        System.out.println(a);
        }
    }
    public static String getStr(int a){
        String str = new String();
        Random r = new Random();
        int num = r.nextInt(a);
            int num1 = r.nextInt(10);
            for (int i = 0; i < a; i++) {
            int num2 = r.nextInt(26) + 65;
            if (i == num){
                str += num1;
            }else{
                str += (char)num2;
            }
        }
        return str;
    }
}
