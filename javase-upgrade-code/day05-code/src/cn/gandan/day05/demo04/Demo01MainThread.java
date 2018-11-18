package cn.gandan.day05.demo04;

/*
    主线程:执行主(main)方法的线程

    单线程程序:java程序中只有一个线程
    执行从main方法开始,从上到下依次执行

    JVM执行main方法,main方法会进入到栈内存
    JVM会找到操作系统开辟一条main方法通向cpu的执行路径
    cpu就可以通过这个路径来执行main方法
    而这个路径有一个名字,叫main(主)线程
 */
public class Demo01MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("艾登.皮尔斯");
        p1.run();

        System.out.println(0/0);// ArithmeticException

        Person p2 = new Person("富兰克林");
        p2.run();
    }
}
