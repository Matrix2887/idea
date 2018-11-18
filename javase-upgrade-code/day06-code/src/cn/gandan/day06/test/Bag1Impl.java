package cn.gandan.day06.test;

public class Bag1Impl implements Runnable{

    private int bag = 10;
    @Override
    public void run() {
    int count = 0;
        while(true){
            synchronized (Bag1Impl.class) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bag > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->第" + bag + "个包");
                    bag--;
                    count++;
             }else {
                    break;
             }
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + count);
    }
}
