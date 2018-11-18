package cn.gandan.day06.test;

/*
    第二题：使用多线程解决以下问题
	有一个包包的数量为100个。分别从实体店和官网进行售卖！
	要求使用多线程的方式，分别打印实体店和官网卖出包包的信息！
	分别统计官网和实体店各卖出了多少个包包，例如：
	官网共卖出了45个
	实体店共卖出了55个
 */
public class Test02 {
    public static void main(String[] args) {
        BagImpl bag1 = new BagImpl("官网");
        BagImpl bag2 = new BagImpl("实体店");
//        Thread th1 = new Thread(bag);
//        Thread th2 = new Thread(bag);
//        bag1.setName("官网");
//        bag2.setName("实体店");
        bag1.start();
        bag2.start();

        Bag1Impl bag = new Bag1Impl();
        Thread th1 = new Thread(bag);
        Thread th2 = new Thread(bag);
        th1.setName("官网");
        th2.setName("实体店");

        th1.start();
        th2.start();

    }
}
