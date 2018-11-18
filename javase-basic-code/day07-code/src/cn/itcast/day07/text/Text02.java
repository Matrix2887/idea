package cn.itcast.day07.text;

import java.util.ArrayList;

public class Text02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("顾加浏");
        list.add("是");
        list.add("宇宙");
        list.add("第一");
        list.add("帅");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
