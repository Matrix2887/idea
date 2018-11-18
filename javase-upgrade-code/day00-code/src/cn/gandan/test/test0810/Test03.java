package cn.gandan.test.test0810;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
3.分析以下需求，并用代码实现
	1.统计每个单词出现的次数
	2.有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
	3.打印格式：
		to=3
		think=1
		you=2
		//........
 */
public class Test03 {
    public static void main(String[] args) {
        String str = "If you want to change your fate I think you must come to the dark horse to learn java";
        HashMap<String, Integer> map = new HashMap<>();
        String[] split = str.split(" ");
        for (String s : split) {
            if(map.containsKey(s)){
                Integer count = map.get(s);
                count++;
                map.put(s,count);
            }else{
                map.put(s,1);
            }
        }
        print(map);
    }
    public static <K,V> void print(Map<K, V> map){
        Set<K> s = map.keySet();
        for (K str : s) {
            V str1 = map.get(str);
            System.out.println(str + "::" + str1);
        }
        System.out.println("========================");
        Iterator<K> it = s.iterator();
        while(it.hasNext()){
            K str = it.next();
            V str1 = map.get(str);
            System.out.println(str + "::" + str1);
        }
        System.out.println("=======================");
        Set<Map.Entry<K, V>> ent = map.entrySet();
        for (Map.Entry<K, V> entry : ent) {
            K key = entry.getKey();
            V value = entry.getValue();
            System.out.println(key + "::" + value);
        }
        System.out.println("=======================");
        Iterator<Map.Entry<K, V>> i = ent.iterator();
        while(i.hasNext()) {
            Map.Entry<K, V> next = i.next();
            K key = next.getKey();
            V value = next.getValue();
            System.out.println(key + "::" + value);
        }
    }
}
