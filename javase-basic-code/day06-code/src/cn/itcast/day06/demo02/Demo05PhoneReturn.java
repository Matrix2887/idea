package cn.itcast.day06.demo02;
/*
11 11 11 11 11 11
当使用一个对象类型作为方法的返回值时：
返回值其实就是对象的【地址值】。
 */
public class Demo05PhoneReturn {
    public static void main(String[] args) {
        Phone two = getIpai();
        System.out.println(two.brand);// 苹果
        System.out.println(two.price);// 8766.0
        System.out.println(two.color);// 玫瑰金
    }

    public static Phone getPhone(){
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8766.0;
        one.color = "玫瑰金";
        return one;
    }

    public static Phone getIpai(){
        Phone three = getPhone();
        System.out.println(three.brand);// 苹果
        System.out.println(three.price);// 8766.0
        System.out.println(three.color);// 玫瑰金
        three.brand = "小米";
        three.price = 8766.0;
        three.color = "菲利普斯绿";
        return three;
    }
}
