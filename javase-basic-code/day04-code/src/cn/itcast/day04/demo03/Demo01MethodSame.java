package cn.itcast.day04.demo03;


/*
题目要求：
定义一个方法，用来判断两个数字是否相同
 */
public class Demo01MethodSame {
    public static void main(String[] args) {
        boolean result = isSame(20,30);
        System.out.println(result);
        isSame1(30,30);
        System.out.println(isSame2(30,40));
        System.out.println(isSame4(30,30));
    }

    /*
    三要素：
    返回值类型：boolean
    方法名称：isSame
    参数列表：int a, int b
     */
    public static boolean isSame(int a , int b ){
        boolean same = a == b;
        return same;// 保证return后面是一个boolean就可以
    }
    public static void isSame1(int a , int b ){
        if (a == b){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
    public static boolean isSame2(int a , int b ){
        boolean same1 = a == b ? true : false;
        return same1;
    }
    public static boolean isSame4(int a , int b ){
        return a ==  b;
    }
}
