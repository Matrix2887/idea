package cn.gandan.day13.Demo03;


/*
    练习:集合元素处理
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
import java.util.stream.Stream;

public class Demo02Test {
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
//        ArrayList<String> oneNew = new ArrayList<>();
        Stream<String> sOne = one.stream();
        Stream<String> o = sOne.filter((str) -> {
            return str.length() == 3;
        }).limit(3);
//        System.out.println(oneNew);
//        3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
//        4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
//        ArrayList<String> twoNew = new ArrayList<>();
        Stream<String> sTwo = two.stream();
        Stream<String> t = sTwo.filter((str) -> {
            return str.startsWith("1");
        }).skip(2);

        Stream.concat(o, t).map(str->new Person(str)).forEach(p->System.out.println(p));


//        System.out.println(twoNew);
//        ArrayList<String> arr = new ArrayList<>();
//        arr.addAll(oneNew);
//        arr.addAll(twoNew);
//        Stream<String> stream = arr.stream();
//        ArrayList<Person> people = new ArrayList<>();
//        stream.forEach((str)->{people.add(new Person(str));});
//        System.out.println(people);


    }
}
