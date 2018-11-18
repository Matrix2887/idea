package cn.gandan.day03.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
    1.键盘录入一个字符串，去掉其中重复字符
    2.打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd。
 */
public class Test03 {
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
