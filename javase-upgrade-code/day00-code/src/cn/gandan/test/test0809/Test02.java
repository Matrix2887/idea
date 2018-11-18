package cn.gandan.test.test0809;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
"第二题：分析以下需求，并用代码实现
"	1.定义List集合，存入多个字符串
"	2.删除集合中字符串"def"
"	3.然后利用迭代器遍历集合元素并输出
 */
public class Test02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("gjl");
        list.add("gyx");
        list.add("lx");
        list.add("def");
        list.add("def");
        list.add("lj");
        list.add("def");
        list.add("lrq");
        for (int i = 0; i < list.size(); i++) {
            list.remove("def");
        }
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
