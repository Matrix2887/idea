package cn.gandan.day04.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
三、分析以下需求，并用代码实现
	1.利用键盘录入，输入一个字符串
	2.统计该字符串中各个字符的数量(提示:字符不用排序)
	3.如：
		用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
		程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)u(4)v(1)w(1)y(3)~(6)

 */
public class Test03 {
    public static void main(String[] args) {
        String sc = "If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = sc.toCharArray();
        for (char c : ch) {
            if(map.containsKey(c)){
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else{
                map.put(c,1);
            }

        }
        Set<Character> c = map.keySet();
        for (Character cha : c) {
            Integer in = map.get(cha);
            System.out.print(cha + "(" + in + ")");

        }
    }
}
