package cn.gandan.day06.demo01;

/*
    线程的名称:
        主线程:    main
        新线程:    Thread-0,thread-1,Thread-2

        cpu就有了选择的权力
 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
        // 创建Thread类的子类对象
        MyThread mt = new MyThread();
        // 调用start方法,开启新线程,执行run方法
        mt.start();

        new MyThread().start();
        new MyThread().start();

        // 链式编程
        System.out.println(Thread.currentThread().getName());

    }
}
