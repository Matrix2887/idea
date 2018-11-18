package cn.itcast.day09.demo02;

/*
在父子类的继承关系中，如果成员变量重名，则创建子类对象时，访问有两种方式:

直接通过子类对象访问成员变量:
    等号左边是谁，就优先用谁，没有则向上找
间接通过成员方法访问成员变量:
    方法属于谁，就优先用谁，没有则向上找
 */
public class Demo01ExtendsField {
    public static void main(String[] args) {
        Father father = new Father();// 创建父类对象
        System.out.println(father.numFather);// 只能使用父类的东西，没有任何子类内容
        System.out.println("==================");

        Son son = new Son();


        System.out.println(son.numFather);// 10
        System.out.println(son.numSon);// 20
        System.out.println("==================");

        // 等号左边是谁，就优先用谁
        System.out.println(son.num);// 优先子类,200
//        System.out.println(son.son);// 到处都没有，编译报错
        System.out.println("==================");

        // 这个方法是子类的，优先用子类的，没有在向上找
        son.methodSon();// 200
        // 这个方法是在父类当中定义的
        son.methodFather();// 100

    }
}
