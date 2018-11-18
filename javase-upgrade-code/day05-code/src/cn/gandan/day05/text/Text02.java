package cn.gandan.day05.text;

/*
    请使用继承Thread类的方式开启两个线程
		(1)第一个线程的名字设置为：a   第二个线程的名字设置为：b
		(2)第一个线程里面实现计算1+2+3+4+....+100的和
		(3)第二个线程里面实现计算1+2+3+4+....+200的和
		程序最终打印结果：
				a:5050
				b:20100   (a和b的打印顺序不作要求)
 */
public class Text02 {
    public static void main(String[] args) {
        MyThread01 mt = new MyThread01();
        mt.setName("a:");
        System.out.print(mt.getName());
        mt.run();
        MyThread02 my = new MyThread02();
        my.setName("b:");
        System.out.print(my.getName());
        my.run();
    }
}
