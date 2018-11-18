package cn.itcast.day00.practice01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
（1）定义一个数组，存储大写字符，小写字符及数字字符
（2）从数组中随机获取10个字符（不考虑是否重复）组成字符串，并将10个用该方式获取的字符串存储到集合中
（3）将集合内的字符串进行打印输出，格式如下：
第1个字符串:......
第2个字符串:......
。。。
 */
public class Test03 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<String> st = new ArrayList<>();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] ch = str.toCharArray();
        for (int i = 0; i < 10; i++) {
            char[] ch1 = new char[10];
            for (int j = 0; j < 10; j++) {
                int count = r.nextInt(ch.length);
                ch1[j] = ch[count];
            }
            st.add(new String(ch1));
            System.out.println("第" + (i + 1) + "个字符串:" + st.get(i));
        }
    }
}
