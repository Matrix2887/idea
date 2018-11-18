package cn.itcast.day11.demo05;

public class MyInterfaceImpl implements MyInterface{
    @Override
    public void method() {
        System.out.println("111实现类覆盖重写");
    }

    @Override
    public void method1() {
        System.out.println("222实现类覆盖重写");
    }
}
