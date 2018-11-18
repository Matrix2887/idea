package cn.gandan.day06.test;

public class RunnableImpl implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        int count = 0;
        while(true){
        synchronized (RunnableImpl.class) {
            if(ticket > 0){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "-->" + ticket + "张票");
                ticket--;
                count++;
            }else{
                System.out.println(count);
                break;
            }
        }
        }
    }
}
