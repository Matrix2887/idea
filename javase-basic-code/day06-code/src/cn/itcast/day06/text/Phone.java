package cn.itcast.day06.text;

public class Phone {
    private String brand;
    private int price;

    public void call(){
        System.out.println("正在使用价格为" + price + "元的" + brand + "品牌的手机打电话");
    }
    public void sendMessage(){
        System.out.println("正在使用价格为" + price + "元的" + brand + "品牌的手机发短信");
    }
    public void playGame(){
        System.out.println("正在使用价格为" + price + "元的" + brand + "品牌的手机玩游戏");
    }

    public Phone() {
    }

    public Phone(String brand, int price) {
        this.brand = brand;
        this.price = price;
        System.out.println("正在使用价格为" + price + "元的" + brand + "品牌的手机玩游戏");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
