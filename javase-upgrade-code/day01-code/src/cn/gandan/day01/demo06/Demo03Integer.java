package cn.gandan.day01.demo06;

/*
    基本类型与字符串类型之间的相互转换
    基本类型->字符串(String)
        1.基本类型的值 + "" 最简单的方法(工作中常用)
        2.包装类的静态方法toString(参数),不是Object类的toString() 重载
            static String toString(int i)返回一个表示指定整数的String对象
        3.String类的静态方法valueOf(参数)
            static String valueOf(int i)返回int参数的字符串表示形式
        字符串(String)->基本类型
            使用包装类的静态方法parseXXX("数值类型的字符串");
                Integer类: static int parseInt(String s)
                Double类: static double parseDouble(String s)
 */
public class Demo03Integer {
    public static void main(String[] args) {
        // 基本类型->字符串(String)
        int i = 100;
        String s = i + "";
        System.out.println(s + 200);// 100200

        String s1 = Integer.toString(100);
        System.out.println(s1 + 300);// 100300

        String s2 = String.valueOf(200);
        System.out.println(s2 + 400);// 200400

        // 字符串(String)->基本类型
        int i1 = Integer.parseInt(s1);
        System.out.println(i1 - 10);


//        int a = Integer.parseInt("a");// NumberFormatException
//        System.out.println(a);


    }
}
