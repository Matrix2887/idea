package cn.itcast.day10.test;

import java.util.Scanner;

/*
1.定义动物类:         属性: 年龄
		             行为: 喝水,吃东西(吃什么不确定)
	2.定义游泳接口:   行为:     游泳方法
	3.定义狗类:      行为:吃饭(啃骨头)和 游泳(狗刨)
	4.定义羊类:      行为:吃饭(羊啃草)
	5.定义青蛙类:    行为:吃饭(吃虫子)和 游泳(蛙泳)
	6.定义饲养员类:  行为:    饲养动物:包括吃饭和喝水
	7.定义测试类:    创建饲养员对象,饲养员调用三次饲养方法:饲养狗,饲养羊,饲养青蛙

	要求:
		1.子类重写父类中的吃东西方法
		2.要求给狗和青蛙添加游泳的方法(实现游泳接口)
		3.饲养员类中定义一个方法,传入动物类对象(父类),
			调用吃饭方法,如果有游泳方法也需进行测试
		4.打印如下格式的结果:
			喝水
			狗啃骨头
			狗会狗刨游泳
			喝水
			青蛙吃小虫
			青蛙会蛙泳
			喝水
			羊啃草
 */
public class Dog extends Animal implements Swim{
    public Dog() {
    }

    public Dog(int age) {
        super(age);
    }


    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗会狗刨游泳");
    }
}
