package cn.itcast.day00.demo0723;

import java.util.ArrayList;
import java.util.Arrays;

/*
将如下数据存入list集合中，"itcast","cn","hei","Python","Java",并完成以下要求：
遍历集合，将集合中长度小于4的元素替换成*
打印替换后的结果
 */
public class Test10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("itcast");
        list.add("cn");
        list.add("hei");
        list.add("Python");
        list.add("Java");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length() < 4){
                list.add(i,"*");
                list.remove(i + 1 );
            }
        System.out.print(list.get(i) + " ");
        }
    }
}
