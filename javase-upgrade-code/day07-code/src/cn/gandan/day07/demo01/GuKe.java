package cn.gandan.day07.demo01;

public class GuKe extends Thread{
    private BaoZi bz;

    public GuKe(BaoZi bz) {
        this.bz = bz;
    }

    // 设置线程任务(run):吃包子
    @Override
    public void run() {
        // 使用死循环,让吃货一直吃包子
        while (true){
            // 必须使用同步技术保证两条线程只能有一个在执行
            synchronized (bz){
                // 对包子的状态进行判断
                if(bz.flag == false){
                    // 吃货调用wait方法进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    bz.flag = false;
                    bz.notify();
                    // 唤醒后,消费包子
                    System.out.println("吃" + bz.pi + bz.xian);
                    System.out.println("===============================");
                }
            }
        }
        }

}
