package cn.gandan.day04.demo01;

import java.util.HashMap;
import java.util.Map;

/*
    java.util.Map<k,v>集合
    Map集合的特点:
        1.Map集合是一个双列集合,一个元素包含两个值(一个key,一个value)
        2.Map集合中的元素,key和value的数据类型可以相同,也可以不同
        3.Map集合中的元素,key是不允许重复的,value是可以重复的
        4.Map集合中的元素,key和value是一一对应的
    java.util.HashMap<k,v>集合 implements Map<k,v>接口
    HashMap集合的特点:
        1.HashMap集合底层是哈希表:查询的速度特别的快
            JDK1.8之前:数组 + 单向链表
            JDK1.8之后:数组 + 单向链表/红黑树(链表的长度超过8):提高查询的速度
        2.hashMap集合是一个无序的集合,存储元素和取出元素的顺序有可能不一致
    java.util.LinkedHashMap<k,v>集合 extend HashMap<k,v>集合
    LinkedHashMap的特点:
        1.LinkedHashMap集合底层是哈希表 + 链表(保证了迭代的顺序)
        2.LinkedHashMap集合是一个有序的集合,存储元素和取出元素的顺序是一致的
 */
public class Demo01Map {
    public static void main(String[] args) {
        methodPut();
        System.out.println("===========================================");
        methodRemove();
        System.out.println("===========================================");
        methodGet();
        System.out.println("===========================================");
        methodContainsKey();
    }

    /*
    boolean containsKey(Object key)判断集合中是否包含指定的值
        包含返回true,不包含返回false

     */
    private static void methodContainsKey() {

        Map<String,Integer> map = new HashMap<>();
        map.put("石原里美",20);
        map.put("柳岩",36);
        map.put("杨幂",30);
        boolean b1 = map.containsKey("杨幂");
        System.out.println(b1);// true
        boolean b2 = map.containsKey("朴草娥");
        System.out.println(b2);// false
    }

    /*
        public V get(Object key)根据指定的键,在Map集合中获取对应的值
            返回值:
                key存在,返回对应的value值
                key不存在,返回null
     */
    private static void methodGet() {
        Map<String,Integer> map = new HashMap<>();
        map.put("石原里美",20);
        map.put("柳岩",36);
        map.put("杨幂",30);

        Integer v1 = map.get("杨幂");
        System.out.println(v1);// 30

        Integer v2 = map.get("朴草娥");
        System.out.println(v2);// null
    }

    /*
        public V remove(Object key):把指定的键,所对应的键值对元素,在Map集合中删除,返回被删除元素的值
            返回值: V
                key存在,v返回被删除的值
                key不存在,v返回null
     */
    private static void methodRemove() {
        // 创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("石原里美",20);
        map.put("柳岩",36);
        map.put("杨幂",30);
        System.out.println(map);// {杨幂=30, 柳岩=36, 石原里美=20}

        Integer v1 = map.remove("杨幂");
        System.out.println(v1);// 30

        System.out.println(map);// {柳岩=36, 石原里美=20}

        Integer v2 = map.remove("朴草娥");
//          int v2 = map.remove("朴草娥");// 自动拆箱 NullPointerException
        System.out.println(v2);// nintull
    }

    /*
        public V put(K key,V value):把指定的键与指定的值添加到Map集合中
            返回值:v
                存储键值对的时候,key不重复,返回值v是null
                存储键值对的时候,key重复,会使用新的value替换map中的value,返回被替换的value值
     */
    private static void methodPut() {
        // 创建Map集合对象,多态
        Map<String,String> map = new HashMap<>();

        String v1 = map.put("艾登.皮尔斯","玛丽.皮尔斯1");
        System.out.println("v1:" + v1);// v1:null

        String v2 = map.put("艾登.皮尔斯","玛丽.皮尔斯2");
        System.out.println("v2:" + v2);// v2:玛丽.皮尔斯

        System.out.println(map);// {艾登.皮尔斯=玛丽.皮尔斯2}

        map.put("福尔摩斯","华生");
        map.put("基拉.大和","阿斯兰.萨尔");
        map.put("穆.拉.弗拉格","劳.鲁.克鲁泽");
        System.out.println(map);

    }
}
