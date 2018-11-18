package cn.gandan.day01.demo02;

/*
    java.util.Date:表示日期和时间的类
    类Date表示特定的瞬间,精确到毫秒
    毫秒:千分之一秒 1000毫秒=1秒

    日期可以转换为毫秒进行计算,计算完毕,在把毫秒转换为时间

    把日期转换为毫秒:
     当前的日期:2016-04-23
     时间原点(0毫秒):1970年1月1日00:00:00(英国格林威治)
     注意:
     中国属于东八区,会把时间增加8个小时
        1970年1月1日08:00:00
     就是计算当前日期到时间原点之间一共经历了多少毫秒

     把毫秒转换成日期:
     1天 = 24 x 60 x 60 = 86400 x 1000 = 86400000毫秒
 */
public class Demo01Date {
    public static void main(String[] args) {
        // 获取当前系统时间到1970年1月1日00:00:00经历了多少毫秒
        System.out.println(System.currentTimeMillis());
    }
}
