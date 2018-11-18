package cn.itcast.day00.demo0723;

/*
（1）定义"军人"类,Solider,包含以下成员：
成员属性：name（姓名）：String类型；age（年龄）：int类型；like(爱好)：String类型；属性使用private修饰
成员方法：
	1.get/set方法
	2.show（）方法，打印对象所有属性的值
    （2）定义类：Test，类中定义main（）方法，按以下要求编写代码：
	1.实例化三个Solider对象，三个对象分别为："王小兵"，25，"打篮球"、"李团长"，35，"游泳"、"王军长"，55，"踢足球"；
	2.创建一个ArrayList集合，这个集合里面存储的是Solider类型，分别将上面的三个Solider对象添加到集合中
	3.遍历这个集合，在遍历的过程中，如果这个集合里面的对象的年龄大于40，那么将集合中的这个对象的爱好改成"打高尔夫"，然后调用这个对象的show（）方法展示这个对象所有的属性信息

 */
public class Solider {
    private String name;
    private int age;
    private String like;

    public Solider() {
    }

    public Solider(String name, int age, String like) {
        this.name = name;
        this.age = age;
        this.like = like;
    }

    public void show(){
        System.out.println("姓名:" + name);
        System.out.println("年龄:" + age);
        System.out.println("爱好:" + like);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
