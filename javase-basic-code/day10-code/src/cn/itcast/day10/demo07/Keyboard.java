package cn.itcast.day10.demo07;

public class Keyboard implements USB {

    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void enter(){
        System.out.println("键入");
    }
}
