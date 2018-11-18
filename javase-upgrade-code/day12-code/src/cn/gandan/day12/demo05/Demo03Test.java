package cn.gandan.day12.demo05;

import java.util.function.Consumer;

public class Demo03Test {
    public static void main(String[] args) {
        String[] arr = {"盛利,18","爆米花,12","豆豆豆豆豆豆变,14"};
        print(arr,(name)->{
            String s = name.split(",")[0];
            System.out.print("姓名" + s);
        },(age)->{
            String s = age.split(",")[1];
            System.out.println("年龄" + s);
        });

    }
    public static void print(String[] arr, Consumer<String> con1,Consumer<String> con2){
        for (String s : arr) {
        con1.andThen(con2).accept(s);
        }
    }
}
