package cn.itcast.day10.demo07;

public class Print implements USB {
    @Override
    public void open() {
        System.out.println("打开打印机");
    }

    @Override
    public void close() {
        System.out.println("关闭打印机");
    }

    public void print(){
        System.out.println("开始打印");
    }
}
