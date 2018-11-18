package cn.gandan.test.test0809;

import java.util.LinkedHashSet;
import java.util.Scanner;

/*
    "第六题：分析以下需求，并用代码实现
    "	键盘读取一行输入,去掉其中重复字符, 打印出不同的那些字符
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        System.out.println("请输入字符");
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (char c : ch) {
            set.add(c);
        }
        for (Character cha : set) {
            System.out.print(cha);
        }
    }
}