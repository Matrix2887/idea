package cn.itcast.day06.demo02;
/*
08 08 08 08 08 08
 */
public class Demo02PhoneTwo {
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

        Phone two = new Phone();
        two.brand = "三星";
        two.price = 6666.0;
        two.color = "电浆黑";
        System.out.println(two.brand);// 三星
        System.out.println(two.price);// 6666.0
        System.out.println(two.color);// 电浆黑
        two.call("朴草娥");
        two.sendMessage();
        System.out.println("=============");

    }
}
