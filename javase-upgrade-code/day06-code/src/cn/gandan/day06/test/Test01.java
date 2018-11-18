package cn.gandan.day06.test;

/*
    第一题：分析以下需求，并用代码实现
	一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
	要求:请用多线程模拟卖票过程并打印剩余电影票的数量
 */
public class Test01 {
    public static void main(String[] args) {
        RunnableImpl ru = new RunnableImpl();
        Thread th1 = new Thread(ru);
        Thread th2 = new Thread(ru);
        th1.start();
        th2.start();

    }
}
