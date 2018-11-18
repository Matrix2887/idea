package cn.itcast.day09.demo12;

public class Son extends Father{

    public Son(){
        // super();
        System.out.println("子类构造方法执行");
    }
    @Override
    public void eat() {
        System.out.println("吃饭");

    }
}
