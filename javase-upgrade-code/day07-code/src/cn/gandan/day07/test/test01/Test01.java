package cn.gandan.day07.test.test01;

/*
1.定义一个Fruit水果类
		成员变量：stock库存
		构造方法、set和get
	2.定义一个官网线程类：NetShop，实现Runnable接口
		完成卖出水果的动作
	3.定义一个实体店线程类：FrontShop，实现Runnable接口
		完成卖出水果的动作
	4.使用等待唤醒机制完成卖出100份坚果的功能
		例如：
			官网正在卖出第1份，还剩余99份
			实体店正在卖出第2份，还剩余98份
			官网正在卖出第3份，还剩余97份
			实体店正在卖出第4份，还剩余96份
			...
 */
public class Test01 {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Runnable r1 = new NetShop(fruit);
        Runnable r2 = new FrontShop(fruit);
        Thread t1 = new Thread(r1,"官网");
        Thread t2 = new Thread(r2,"实体店");
        t1.start();
        t2.start();
    }
}
