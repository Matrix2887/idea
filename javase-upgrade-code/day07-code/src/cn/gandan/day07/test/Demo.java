package cn.gandan.day07.test;

public class Demo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        new LittleBlue("1小兰",apple).start();
        new LittleGreen("2小绿",apple).start();
        new LittlePink("3小粉",apple).start();
        new LittleRed("4小红",apple).start();
    }
}
