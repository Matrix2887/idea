package cn.gandan.day13.Demo03;


/*
    练习:集合元素处理（传统方式）
        现在有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以下若干操作步骤：
        1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        6. 根据姓名创建Person对象；存储到一个新集合中。
        7. 打印整个队伍的Person对象信息。
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class Demo01Test {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("1盛利");
        one.add("2盛利");
        one.add("3-盛利");
        one.add("4-盛利");
        one.add("5盛利");
        one.add("6-盛利");
        one.add("7盛利");
        one.add("8-盛利");
        ArrayList<String> two = new ArrayList<>();
        two.add("1-石原里美");
        two.add("12-石原里美");
        two.add("1-石原里美");
        two.add("13-石原里美");
        two.add("5-石原里美");
        two.add("6-石原里美");
        two.add("7-石原里美");
//        1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
//        2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        ArrayList<String> oneNew = new ArrayList<>();
        ArrayList<String> oneNewTwo = new ArrayList<>();
        for (String s : one) {
            if(s.length()==3){
                oneNew.add(s);
            }
        }
        System.out.println(oneNew);
        for (int i = 0; i < 3; i++) {
            oneNewTwo.add(oneNew.get(i));
        }
        System.out.println(oneNewTwo);
        System.out.println("==============");

//        3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
//        4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        ArrayList<String> twoNew = new ArrayList<>();
        ArrayList<String> twoNewTwo = new ArrayList<>();
        for (String s : two) {
            if(s.startsWith("1")){
                twoNew.add(s);
            }
        }
        System.out.println(twoNew);
        for (int size = twoNew.size()-2; size > 0; size--) {
            twoNewTwo.add(twoNew.get(size));
        }
        System.out.println(twoNewTwo);
//
//        5. 将两个队伍合并为一个队伍；存储到一个新集合中。
//        6. 根据姓名创建Person对象；存储到一个新集合中。
//        7. 打印整个队伍的Person对象信息。
        ArrayList<String> arr = new ArrayList<>();
        arr.addAll(oneNewTwo);
        arr.addAll(twoNewTwo);
        ArrayList<Person> p = new ArrayList<>();
        for (String s : arr) {
            p.add(new Person(s));
        }
        System.out.println(p);

    }
}
