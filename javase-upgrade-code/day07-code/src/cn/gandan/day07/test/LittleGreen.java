package cn.gandan.day07.test;

public class LittleGreen extends Thread{
    private Apple apple;

    public LittleGreen(String name,Apple apple) {
        super(name);
        this.apple = apple;
    }

    public LittleGreen(Apple a) {
        this.apple = a;
    }

    @Override
    public void run() {
        while (true){
//            if(Apple.count > 0) {
            if(apple.count > 0) {
                synchronized (Apple.class) {
                    if (apple.flat % 4 == 1) {
                        System.out.println(Thread.currentThread().getName() + "吃" + apple.name);
//                        Apple.flat++;
                        apple.flat++;
//                        Apple.count--;
                        apple.count--;
                        Apple.class.notifyAll();
                        System.out.println(apple.count + "-->" + apple.flat);
                    } else {
                        try {
                            Apple.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }else{
                break;
            }
        }
    }
}
