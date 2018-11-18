package cn.itcast.day10.demo07;

public class Demo {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Print print = new Print();
        Computer computer = new Computer();
        Keyboard keyboard = new Keyboard();
        computer.powerOn();
        computer.useDevice(mouse);
        computer.useDevice(keyboard);
        computer.useDevice(print);
        computer.powerOff();
    }
}
