package cn.itcast.day10.demo07;

public class Computer{

    public void powerOn(){
        System.out.println("开机");
    }

    public void powerOff(){
        System.out.println("关机");
    }

    public void useDevice(USB usb){
            usb.open();
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }else if(usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard) usb;
            keyboard.enter();
        }else if(usb instanceof Print){
            Print print = (Print) usb;
            print.print();
        }
            usb.close();


    }




}
