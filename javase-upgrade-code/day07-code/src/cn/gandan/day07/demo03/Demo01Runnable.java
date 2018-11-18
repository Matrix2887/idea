package cn.gandan.day07.demo03;

public class Demo01Runnable {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread t = new Thread(run);
        t.start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(2 + Thread.currentThread().toString());
            }
        };
        new Thread(r).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3 + Thread.currentThread().toString());
            }
        }).start();
    }
}
