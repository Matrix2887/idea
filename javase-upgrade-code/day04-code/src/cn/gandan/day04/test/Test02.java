package cn.gandan.day04.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
二、有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
               第二个数组内容为：[哈尔滨,杭州,南昌,广州,福州]，
			   将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
			   如{黑龙江省=哈尔滨, 浙江省=杭州, …}。
			   使用两种方式遍历map集合
 */
public class Test02 {
    public static void main(String[] args) {
        String[] ground = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] city = {"哈尔滨","杭州","南昌","广州","福州"};
        HashMap<String ,String> map = new HashMap<>();

        for (int i = 0; i < ground.length; i++) {
            map.put(ground[i],city[i]);
        }
        Set<String> str = map.keySet();
        for (String s : str) {
            String j = map.get(s);
            System.out.println(s + "=" + j);
        }
        System.out.println("================");
        Set<Map.Entry<String, String>> ent = map.entrySet();
        for (Map.Entry<String, String> entry : ent) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
