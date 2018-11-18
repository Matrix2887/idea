package cn.gandan.day06.test;

public class BagImpl extends Thread{
    public BagImpl(String name) {
        super(name);
    }
    private int count = 0;
    private static int bag = 10;
    @Override
    public void run() {
        while(true){
            synchronized (BagImpl.class){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(bag > 0){
                 System.out.println(Thread.currentThread().getName() + "-->第" + bag + "个包");
                 bag--;
                 count++;
             }else {
                System.out.println(this.getName() + count);
                break;
             }
            }
        }
    }
}
