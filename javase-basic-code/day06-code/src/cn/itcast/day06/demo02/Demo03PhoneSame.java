package cn.itcast.day06.demo02;
/*
09 09 09 09 09 09
 */
public class Demo03PhoneSame {
    public static void main(String[] args) {
        // 根据Phone类，创建一个名为one的对象
        // 格式：类名称 对象名 = new 类名称();
        Phone one = new Phone();
        System.out.println(one.brand);// null
        System.out.println(one.price);// 0
        System.out.println(one.color);// null
        System.out.println("=============");

        one.brand = "苹果";
        one.price = 8766.0;
        one.color = "电浆粉红";
        System.out.println(one.brand);// 苹果
        System.out.println(one.price);// 8766
        System.out.println(one.color);// 电浆粉红
        System.out.println("=============");

        one.call("习近平");
        one.sendMessage();

        // 将one当中保存的地址值保存给two
        Phone two = one;
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);
        two.brand = "三星";
        two.price = 6666.0;
        two.color = "电浆黑";
        System.out.println(two.brand);// 三星
        System.out.println(two.price);// 6666.0
        System.out.println(two.color);// 电浆黑
        two.call("朴草娥");
        two.sendMessage();
        System.out.println("=============");

        Phone three = two;
        System.out.println(three.brand);
        System.out.println(three.price);
        System.out.println(three.color);
        System.out.println("=============");
        three.brand = "小米";
        three.price = 2555;
        three.color = "宝强绿";
        System.out.println(three.brand);
        System.out.println(three.price);
        System.out.println(three.color);


    }
}
