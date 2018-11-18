package cn.itcast.day00.practice01;

import java.util.Scanner;

/*
（1）定义抽象类Drink类（饮品类）,属性：sweetness（甜度，String类型），抽象方法：mark(信息标记)
（2）定义接口With_milk（加奶），方法：add_Milk,参数：int数据，用来选择加奶方式
（3）定义Coffee(咖啡)类，继承饮品类，实现接口With_milk
	定义Fruit_juice（果汁）类，继承饮品类
（4）定义Liquor_store（饮品店）类,方法：process（加工），方法功能如下：
传递Drink类对象，对传递的对象进行判断，如果是Coffee对象，
1.提示用户“请选择甜度”（甜度数值为int类型，通过键盘录入）
甜度范围如下：
1 无糖    2 半糖    3 七分糖   4 全糖
使用用户选择的甜度为传递的Coffee对象进行初始化
2.提示用户“请选择加奶方式”（加奶方式为int类型，通过键盘录入）
加奶方式如下：
1 奶泡    2 奶油    3 半奶
使用Coffee对象，调用mark方法，打印对象信息，甜度：...加奶：...

如果是Fruit_juice对象，
1.提示用户“请选择甜度”（甜度数值为int类型，通过键盘录入）
甜度范围如下：
1 无糖    2 半糖    3 七分糖   4 全糖
使用用户选择的甜度为传递的Fruit_juice对象进行初始化
使用Fruit_juice对象，调用mark方法，打印对象信息，甜度：...
（5）定义测试类Test05，在main方法中创建Coffee类对象及Fruit_juice类对象，
创建Liquor_store对象，调用process方法，传递Coffee类对象及Fruit_juice类对象进行测试，并打印对象信息
 */
public class Coffee extends Drink {

    private String milk;


    public Coffee() {

    }

    public Coffee(String sweetness,String milk) {
        super(sweetness);
        this.milk = milk;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }
//    @Override
//    public void add_Milk(String milk) {
//        System.out.println("加奶:" + milk);
//    }

    @Override
    public void mark() {
        With_milk with_milk = new With_milk(){
            @Override
            public void add_Milk(int milk) {
                System.out.println("咖啡:");
                switch(milk){
                    case 1 :
                        System.out.println("加奶:奶泡");
                        break;
                    case 2:
                        System.out.println("加奶:奶油");
                        break;
                    case 3:
                        System.out.println("加奶:半奶");
                        break;
                    default:
                        System.out.println("加奶:傻逼,滚");
                        break;
                }
            }
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择加奶方式:1.奶泡 2.奶油 3.半奶");
        with_milk.add_Milk(sc.nextInt());
        System.out.println("甜度:" + getSweetness());
    }


//    public void show(String sweetness,String milk){
//        System.out.println("咖啡:");
//        System.out.println("甜度:" + sweetness);
//        System.out.println("加奶:" + milk);
//    }
}
