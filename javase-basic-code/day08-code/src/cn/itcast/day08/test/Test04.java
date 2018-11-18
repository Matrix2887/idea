package cn.itcast.day08.test;

/*
	要求:完成代码(按照标准格式写)，然后在测试类中测试。
		1.手机类Phone
		  属性:品牌brand,价格price
		  无参构造,有参构造
		  行为:打电话call,发短信sendMessage,玩游戏playGame
		2.测试类
		  创建Phone类对象,调用Phone类中的方法

		  思考:假设所有的手机都有属性屏幕的尺寸(int size),而且假设所有手机的屏幕尺寸为6,应该如何实现?
 */
public class Test04 {
    public static void main(String[] args) {
        Phone one = new Phone();
        Phone two = new Phone();
        one.setBrand("菲利普全功能防水机");
        one.setPrice(6000);
        one.setSize(6);
        System.out.println(one.getBrand() + "\t" + one.getPrice() + "\t" +  one.getSize());
        one.call("唐嫣");
    }
}