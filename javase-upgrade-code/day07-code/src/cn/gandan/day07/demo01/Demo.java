package cn.gandan.day07.demo01;

public class Demo {
    public static void main(String[] args) {
        // 创建包子对象
        BaoZi bz = new BaoZi();
        // 创建包子铺线程,开启,生产包子
        BaiZiPu baiZiPu = new BaiZiPu(bz);
        // 创建顾客线程,开启,消费包子
        GuKe guKe = new GuKe(bz);
        baiZiPu.start();
        guKe.start();
    }
}
