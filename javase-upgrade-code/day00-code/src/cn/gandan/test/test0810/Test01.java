package cn.gandan.test.test0810;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
1.分析以下需求，并用代码实现
	1.定义一个map集合,key为String类型的姓名,value为String类型地址,存入数据多条数据(假设不存在重名的情况),并用多种方式遍历
	2.定义一个map集合,key为Student类型的对象,value为String类型的地址,存入数据多条数据(需要加入对象的唯一性判断)
		(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)、成绩(int score)
		(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
		(3)利用四种方式遍历Map集合中的内容，格式：key::value
 */
public class Test01 {
    public static void main(String[] args) {
        HashMap<Student, String> stu = new HashMap<>();
        stu.put(new Student("艾登.皮尔斯",38,200),"芝加哥");
        stu.put(new Student("CJ",25,50),"圣安地列斯");
        stu.put(new Student("富兰克林",32,60),"洛圣都");
        print(stu);


        Map<String, String> map = new HashMap<>();
        map.put("艾登.皮尔斯","芝加哥");
        map.put("CJ","圣安地列斯");
        map.put("富兰克林","洛圣都");
        print(map);
//        Set<String> s = map.keySet();
//        for (String str : s) {
//            String str1 = map.get(str);
//            System.out.println(str + " ->" + str1);
//        }
//        System.out.println("========================");
//        Iterator<String> it = s.iterator();
//        while(it.hasNext()){
//            String str = it.next();
//            String str1 = map.get(str);
//            System.out.println(str + " ->" + str1);
//        }
//        System.out.println("=======================");
//        Set<Map.Entry<String, String>> ent = map.entrySet();
//        for (Map.Entry<String, String> entry : ent) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + "-->" + value);
//        }
//        System.out.println("=======================");
//        Iterator<Map.Entry<String, String>> i = ent.iterator();
//        while(i.hasNext()) {
//            Map.Entry<String, String> next = i.next();
//            String key = next.getKey();
//            String value = next.getValue();
//            System.out.println(key + "-->" + value);
//        }

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
