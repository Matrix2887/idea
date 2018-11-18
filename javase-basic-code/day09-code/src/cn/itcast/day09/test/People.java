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
public class People {
    private String peopleName;
    private int peopleAge;

    public void show(){
        System.out.println("姓名:" + peopleName + " 年龄:" + peopleAge);
    }
    public void keepPet(Dog dog,String something){
        this.show();
        dog.eat("骨头");
        dog.show();
        System.out.println("姓名为:" + peopleName + " 喂养宠物狗吃" + something);
    }
    public void keepPet(Cat cat,String something){
        this.show();
        cat.eat("鱼");
        cat.show();
        System.out.println("姓名为:" + peopleName + " 喂养宠物猫吃" + something);
    }

    public People() {
    }


    public People(String peopleName, int peopleAge) {
        this.peopleName = peopleName;
        this.peopleAge = peopleAge;
    }


    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public int getPeopleAge() {
        return peopleAge;
    }

    public void setPeopleAge(int peopleAge) {
        this.peopleAge = peopleAge;
    }
}
