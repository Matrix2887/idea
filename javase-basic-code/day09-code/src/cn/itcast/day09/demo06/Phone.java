package cn.itcast.day09.demo06;

/*
设计原则:
对于已经投入使用的类，尽量不要进行修改。推荐定义一个新的类，
来重复利用其中共性内容并且添加改动新内容

继承

本来老款手机
 */
public class Phone {
    public void call(){
        System.out.println("打电话");
    }
    public void send(){
        System.out.println("发短信");
    }
    public void show(){
        System.out.println("显示号码");
    }
    public void game(){
        System.out.println("玩俄罗斯方块");
    }
}
