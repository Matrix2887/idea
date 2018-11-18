package cn.gandan.day13.demo01;

import java.util.ArrayList;

/*
    使用传统的方式,遍历集合,对集合中的数据进行过滤
 */
public class Demo01LIst {
    public static void main(String[] args) {
        //创建一个List集合,存储姓名
        ArrayList<String> list = new ArrayList<>();
        list.add("盛利");
        list.add("盛开");
        list.add("爆米花");
        list.add("石原里美");
        list.add("橘子皮");

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        ArrayList<String> listA = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("盛")){
                listA.add(s);
            }
        }
        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        ArrayList<String> listB = new ArrayList<>();
        for (String s : listA) {
            if(s.length() == 2){
                listB.add(s);
            }
        }
        //遍历listB集合
        System.out.println(listB);

    }
}

