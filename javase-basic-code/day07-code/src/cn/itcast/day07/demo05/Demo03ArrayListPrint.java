package cn.itcast.day07.demo05;

import java.util.ArrayList;

/*
题目：
定义以指定格式打印集合的方法(ArrayList类型作为参数)，使用{}扩起集合，使用@分隔每个元素。
格式参照{元素@元素@元素}

System.out.println(list);   [10, 20, 30]
printlnArrayList(list);     {10@20@30}
 */
public class Demo03ArrayListPrint {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("海恩斯");
        list.add("麦克迪圣塔");
        list.add("崔佛菲利普");
        list.add("富兰克林");
        System.out.println(list);// [海恩斯, 麦克迪圣塔, 崔佛菲利普, 富兰克林]

        printArrsyList(list);
    }

    /*
    定义方法三要素
    返回值类型：只是进行打印而已，没有运算，没有结果；所以用void
    方法名称：printArrayList
    参数列表：ArrayList
     */
    public static void printArrsyList(ArrayList<String> list){
        //{10@20@30}
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == list.size() - 1){
                System.out.println(name + "}");
            }else {
                System.out.print(name + "@");
            }
        }

    }
}
