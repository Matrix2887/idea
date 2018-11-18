package cn.gandan.day06.demo06;

/*
    单线线程是不会出现线程安全问题的
    多线程访问了共享的数据,会产生线程安全问题

    模拟卖票案例
    创建3个线程,同时开启,对共享的票进行出售

    注意:
        线程安全问题是不能产生的,我们可以让一个线程在访问共享数据的时候,
        无论是否失去了cpu的执行权,让其他的线程只能等待,等待当前线程卖完票,其他线程在进行卖票
        保证使用一个线程在卖票
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        // 创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        // 调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}
