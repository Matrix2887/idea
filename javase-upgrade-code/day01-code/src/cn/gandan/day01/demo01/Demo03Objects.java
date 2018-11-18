package cn.gandan.day01.demo01;

import java.util.Objects;

public class Demo03Objects {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
//        System.out.println(s1.equals(s2));
        /*
        Objects类的equals方法:对两个对象进行比较,防止空指针异常
        public static boolean equals(Object a,Object b){
            return(a == b) ||(a != null && a.equals(b));
        }
         */
        System.out.println(Objects.equals(s1,s2));
    }
}
