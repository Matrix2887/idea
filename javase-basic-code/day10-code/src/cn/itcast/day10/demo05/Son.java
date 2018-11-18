package cn.itcast.day10.demo05;

public class Son extends Father{

    private int num;

    public Son() {
    }

    public Son(int num, int num1) {
        super(num);
        this.num = num1;
    }

    @Override
    public void showNum() {
        System.out.println(num);
    }
    @Override
    public void method(){
        System.out.println("子类方法");
    }

    public void methodSon(){
        System.out.println("子类特有方法");
    }
}
