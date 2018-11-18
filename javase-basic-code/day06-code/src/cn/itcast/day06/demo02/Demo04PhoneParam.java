package cn.itcast.day06.demo02;

/*
10 10 10 10 10 10 10 10 10 10

当一个对象作为参数，传递到方法当中时，实际上传递进去的是对象的【地址值】
数组也是传递地址值
 */
public class Demo04PhoneParam {
    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8766.0;
        one.color = "电浆粉红";

        method(one);// 传递进去的参数其实就是地址值
    }

    public static void method(Phone param){
        System.out.println(param.brand);
        System.out.println(param.price);
        System.out.println(param.color);
    }
}
