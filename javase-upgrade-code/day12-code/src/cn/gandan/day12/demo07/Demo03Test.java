package cn.gandan.day12.demo07;

import java.util.function.Function;

public class Demo03Test {
    public static void main(String[] args) {
        String str = "盛利,18";
        chang(str,(s)->{
            return Integer.parseInt(s.split(",")[1]);
        },(i)->{
            return i-2;
        });

    }

    public static void chang(String str, Function<String,Integer> fun1,Function<Integer,Integer> fun2){
        Integer age = fun1.andThen(fun2).apply(str);
        System.out.println(age);

    }
}
