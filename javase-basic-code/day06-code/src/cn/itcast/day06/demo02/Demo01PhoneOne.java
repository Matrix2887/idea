package cn.itcast.day06.demo02;
/*
07 07 07 07 07 07 07 07
 */
public class Demo01PhoneOne {
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

        one.call("渣渣电脑");

        one.game("彩虹六号");
        System.out.println("=============");
        Phone two = new Phone();
        two.color = "紫色激情";
        System.out.println(two.color);

    }
}
