package cn.gandan.day04.demo02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    HashMap存储自定义类型键值
    Map集合保证key是唯一的:
        作为key的元素,必须重写hashCode方法和equals方法,以保证key唯一
 */
public class Demo01HashMapSavePerson {
    public static void main(String[] args) {
        person01();
        person02();
    }

    /*
        HashMap存储自定义类型键值
        key:Person类型
            Person类就必须重写hashCode方法和equals方法,以保证key唯一
        value:String类型
            可以重复
     */
    private static void person02() {
        // 创建HashMap集合
        HashMap<Person, String> map = new HashMap<>();
        // 往集合中添加元素
        map.put(new Person("福尔摩斯",38),"英国");
        map.put(new Person("华生",38),"英国");
        map.put(new Person("哈利波特",28),"英国");
        map.put(new Person("福尔摩斯",38),"爱尔兰");
        // 使用entrySet和增强for遍历Map集合
        Set<Map.Entry<Person, String>> set = map.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-->" + value);
        }


    }

    /*
        HashMap存储自定义类型键值
        key:String类型
            String类重写hashCode方法和equals方法,可以保证key唯一
        value:Person类型
            value可以重复(同名同年龄的人视为同一个人)
     */
    private static void person01() {
        // 创建HashMap集合
        HashMap<String,Person> map = new HashMap<>();

        // 往集合中添加元素
        map.put("芝加哥",new Person("艾登.皮尔斯",35));
        map.put("洛圣都",new Person("富兰克林",25));
        map.put("圣安地列斯",new Person("艾登.皮尔斯",35));
        map.put("芝加哥",new Person("玛丽.皮尔斯",35));
        // 使用keySet加增强for遍历Map集合
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key + "-->" + value);
        }


    }
}
