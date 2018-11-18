package cn.itcast.day07.text;

import java.util.ArrayList;

public class Text03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer>list1 = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("def");
        list.add("ghi");
        list.add("def");
        list.add("hij");
        list.add("jkol");
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if ("def".equals(list.get(i))){
                list1.add(i);
                count++;
            }
        }
        System.out.println("\"def\"字符串一共出现" + count + "个");
        for (int i = 0, x = 0 ; i < list1.size(); i++, x++) {
            int a = list1.get(i) - x;
            list.remove(a);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
