package cn.gandan.test.test0809;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
第三题：分析以下需求，并用代码实现
	1.定义List集合，存入多个字符串
	2.删除集合元素字符串中包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
	3.然后利用迭代器遍历集合元素并输出
 */
public class Test03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("gjl");
        list.add("gjl");
        list.add("gj0l");
        list.add("g00jl");
        list.add("gjl0");
        list.add("0gjl0");
        list.add("0g0jl0");
        Iterator<String> count = list.iterator();
        while (count.hasNext()) {
            char[] c = count.next().toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] >= '0' && c[j] <= '9') {
                    count.remove();
                    break;
                }
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            char[] ch = list.get(i).toCharArray();
//            for (int j = 0; j < ch.length; j++) {
//                if(ch[j] >= '0' && ch[j] <= '9'){
//                    list.remove(i);
//                    i--;
//                    break;
//                }
//            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + ' ');
            }
        }
}



