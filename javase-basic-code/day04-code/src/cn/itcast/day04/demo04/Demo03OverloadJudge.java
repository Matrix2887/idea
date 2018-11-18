package cn.itcast.day04.demo04;

public class Demo03OverloadJudge {
    public static void open () {}// 正确
    public static void open (int a){}// 正确
//    static void open(int a,int b){}// 错误 与11冲突
    public static void open(double a,int b){}// 正确
//    public static void open(int a,double b){}// 错误 与9冲突
//    public  void  open (int i,double d){}// 错误 与8冲突
    public  static void  OPEN(){}// 正确 并不是有效重载
//    public  static  void open(int i,int j){}// 错误 与6冲突
}
