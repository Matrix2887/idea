package cn.itcast.day06.text;
import cn.itcast.day06.text.Phone;

public class Text01 {
    public static void main(String[] args) {
        Phone phone = new Phone("三星",888);
        phone.setBrand("小米");
        phone.setPrice(998);
        phone.call();
        phone.sendMessage();
        phone.playGame();
    }
}
