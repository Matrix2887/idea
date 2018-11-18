package cn.itcast.day10.test;

public class Computer {
    public void powerOn(){
        System.out.println("开机");
    }

    public void powerOff(){
        System.out.println("关机");
    }

    public void useDevice(USB usb){
        usb.open();
        usb.close();
    }
}
