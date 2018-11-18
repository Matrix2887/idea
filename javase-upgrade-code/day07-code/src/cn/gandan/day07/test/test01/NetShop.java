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
public class NetShop implements Runnable{
    private Fruit fruit;
    public NetShop(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void run() {
        while(true){
            synchronized (Fruit.class){
                if(fruit.getStock() > 0 ){
                    if(fruit.flag == 0){
                        fruit.count++;
                        fruit.setStock(fruit.getStock() - 1);
                        System.out.println(Thread.currentThread().getName() + "官网正在卖出第"+fruit.count+"份，还剩余"+fruit.getStock()+"份");
                        fruit.flag = 1;
                        Fruit.class.notifyAll();
                    }else {
                        try {
                            Fruit.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    break;
                }
            }
        }
    }
}
