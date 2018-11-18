package cn.gandan.day04.demo03;

import java.util.HashMap;
import java.util.Set;

/*
    练习:
        计算一个字符串中每个字符出现次数
    分析:
        1.使用Scanner获取用户输入的字符串
        2.创建Map集合,key是字符串中的字符,value是字符的个数
        3.遍历字符串,获取每一个字符
        4.使用获取到的字符,去Map集合判断key是否存在
            Key存在:
                通过字符(key),获取value(字符个数)
                value++
                put(key,value)把新的value存储到Map集合中
            Key不存在:
                put(key,1)
        5.遍历Map集合,输出结果
 */
public class Demo03MapTest {
    public static void main(String[] args) {
        String s = "fuckyoubitchyouareapigandshitmotherfucher";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(!(map.containsKey(ch[i]))){
                map.put(ch[i],1);
            }else{
                Integer value = map.get(ch[i]);
                value++;
                map.put(ch[i],value);
            }
        }
        Set<Character> set = map.keySet();
        for (Character c : set) {
            Integer i = map.get(c);
            System.out.println(c + "=" + i);
        }
    }
}
