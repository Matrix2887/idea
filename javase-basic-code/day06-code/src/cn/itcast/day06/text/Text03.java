package cn.itcast.day06.text;

public class Text03 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.setColor("花色");
        cat.setBreed("波斯猫");
        cat.eat();
        cat.catchMouse();
        dog.setColor("黑色的");
        dog.setBreed("藏獒");
        dog.eat();
        dog.lookHome();
    }
}
