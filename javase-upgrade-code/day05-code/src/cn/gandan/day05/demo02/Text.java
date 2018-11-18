package cn.gandan.day05.demo02;

import java.util.*;

/*
    要求:模拟注册操作,如果用户名已存在,则抛出异常并提示:亲,该用户已经被注册

    分析:
        1.使用数组保存已经注册过的用户名(数据库)
        2.使用Scanner获取用户输入的注册的用户名(前端,页面)
        3.定义一个方法,对用户输入的中注册的用户进行判断
            遍历存储已经注册过用户名的数组,获取每一个用户名
            使用获取到的用户名和用户输入的用户名比较
            true:用户名已经存在,抛出RegisterException异常,告知用户
            false:继续遍历比较 如果循环结束了,还没有找到重复的用户名,提示用户可以注册
 */
public class Text {
        static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        set.add("福尔摩斯");
        set.add("飘断雕");
        set.add("庐初滈");
        Scanner sc = new Scanner(System.in);
        String name;// "飘断雕"
        while(true){


        try{
            System.out.println("请输入");
            name = sc.next();
            rather(name);
            break;
        }catch(RuntimeException e){
            System.out.println(e);
            continue;
        }

        }
        System.out.println("可以注册");
        }

    public static void rather(String name) throws RuntimeException{
        for (String str : set) {
            if(set.contains(name)){
                throw new RuntimeException("亲,该用户名已经被注册");
            }
        }
    }
}
