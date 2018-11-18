package cn.gandan.test.test0809;

import java.util.LinkedHashSet;
import java.util.Random;

/*
"第七题：分析以下需求，并用代码实现
"	1.产生10个1-20之间的随机数要求随机数不能重复
"	2.产生10个长度为10的不能重复的字符串(里面只能出现大写字母、小写字母、0-9的数字)，并遍历打印输出

 */
public class Test07 {
    public static void main(String[] args) {
        Random ra = new Random();
        LinkedHashSet<Integer> in = new LinkedHashSet<>();
        LinkedHashSet<String> str = new LinkedHashSet<>();
       while(in.size() < 10){
           in.add(ra.nextInt(19) + 1);
       }
        for (Integer m : in) {
            System.out.print(m + " ");
        }
        System.out.println();
        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHUJKLMNOPQRSTUVWXYZ";
        char[] ch = s.toCharArray();
        while (str.size() < 10){
        String count = "";
            for (int i = 0; i < 10; i++) {
                count += ch[ra.nextInt(ch.length)];
            }
            str.add(count);
        }
        for (String n : str) {
            System.out.println(n);
        }

    }
}
