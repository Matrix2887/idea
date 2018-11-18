package cn.gandan.day12.demo05;

import java.util.function.Consumer;

/*
    谁写前面 谁先消费
    定义一个方法 方法的参数传递一个字符串和两个接口

 */
public class Demo02AndThen {
    public static void main(String[] args) {
        showAndThen("爆米花",(s)->{
            System.out.println(new StringBuilder(s).reverse().toString() + "1");
        },(s)->{
            System.out.println(new StringBuilder(s).reverse().toString() + "2");
        });
    }


    public static void showAndThen(String s, Consumer<String> con1,Consumer<String> con2){
        con1.accept(s);
        con2.accept(s);
        System.out.println("===============");
        con2.andThen(con1).accept(s);

    }
}
