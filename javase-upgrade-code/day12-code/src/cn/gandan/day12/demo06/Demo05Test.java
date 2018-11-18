package cn.gandan.day12.demo06;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
    练习：集合信息筛选
    数组当中有多条“姓名+性别”的信息如下，
    String[] array = { "盛利,女", "爆米花,女", "艾登.皮尔斯,男", "石原,女" };
    请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，
    需要同时满足两个条件：
        1. 必须为女生；
        2. 姓名为2个字。

    分析:
        1.有两个判断条件,所以需要使用两个Predicate接口,对条件进行判断
        2.必须同时满足两个条件,所以可以使用and方法连接两个判断条件
 */
public class Demo05Test {
    public static void main(String[] args) {
        // 定义一个储存字符串的数组
        String[] array = { "盛利,女", "爆米花,女", "艾登,男", "石原,女" };
        ArrayList<String> arrayList= check(array, (str) -> {
            // 获取字符串的姓名,判断长度是否为2个字符
            String[] arr = str.split(",");
           return arr[0].length()==2;
        },(str)->{
            // 获取字符串的性别,判断是否为女
            String[] arr = str.split(",");
            return "女".equals(arr[1]);
        });

        System.out.println(arrayList);

    }
    public static ArrayList<String> check(String[] array, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> arr = new ArrayList<>();
        // 遍历数组,获取数组中的每一条信息
        for (String s : array) {
            // 使用Predicate接口中发方法test对获取到的字符串进行判断
            // 对得到的布尔值进行判断
            if(pre1.and(pre2).test(s)){
                // 条件成立,两个条件都满足,把信息存储到ArrayList集合中
                arr.add(s);
            }
        }
        // 把集合返回
        return arr;
    }
}
