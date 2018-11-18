package cn.itcast.day08.demo03;

/*
public class 类名称{
    static {
        // 静态代码块的内容
    }
}
特点：当第一次用到本类是，静态代码块执行唯一的一次
 */
public class Person {
    public Person(){
        System.out.println("构造方法执行！");
    }
    static {
        System.out.println("静态代码块执行！");
    }


}
