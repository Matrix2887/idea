package cn.itcast.day09.test;

/*
1.定义动物类
		属性：
			年龄，颜色
		行为:
			eat(String something)方法(无具体行为,不同动物吃的方式和东西不一样,something表示吃的东西)
			生成空参有参构造，set和get方法

	2.定义狗类继承动物类
		行为:
			eat(String something)方法,看家lookHome方法(无参数)

	3.定义猫类继承动物类
		行为:eat(String something)方法,逮老鼠catchMouse方法(无参数)

	4.定义Person类 //饲养动物  有一个方法可以传递东西
		属性：
			姓名，年龄
		行为：
			keepPet(Dog dog,String something)方法
				功能：喂养宠物狗，something表示喂养的东西
		行为：
			keepPet(Cat cat,String something)方法
				功能：喂养宠物猫，something表示喂养的东西
		生成空参有参构造，set和get方法

	5.测试以上方法
 */
public class Test03 {
    public static void main(String[] args) {
        People people = new People("郭",20);
        people.keepPet(new Dog(2, "金色"),"狗粮");
        people.keepPet(new Cat(1,"蓝色"),"猫粮");
    }
}
