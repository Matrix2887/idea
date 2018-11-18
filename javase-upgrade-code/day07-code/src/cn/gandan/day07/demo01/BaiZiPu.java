package cn.gandan.day07.demo01;

public class BaiZiPu extends Thread{
    private BaoZi bz;

    public BaiZiPu(BaoZi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        // 定义一个变量
        int count = 0;
        // 让包子铺一直生产包子
        while(true){
            synchronized (bz){
                if(bz.flag == true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    if(count % 2 == 0){
                        bz.pi = "薄皮";
                        bz.xian = "肉";
                    }else {
                        bz.pi = "厚皮";
                        bz.xian = "素";
                    }
                    count++;
                    System.out.println("生产" + bz.pi + bz.xian);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 包子铺生产好包子
                    // 修改包子的状态为true有
                    bz.flag = true;
                    // 唤醒顾客线程,让顾客消费
                    bz.notify();
                    System.out.println("包子好了" + bz.pi + bz.xian);
                }
            }
        }
        }

}
