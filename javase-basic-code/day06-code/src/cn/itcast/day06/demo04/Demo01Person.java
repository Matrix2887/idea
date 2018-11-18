package cn.itcast.day06.demo04;

public class Demo01Person {
    public static void main(String[] args) {
        Person person = new Person();
        // 设置我自己的名子
        person.name = "王健林";
        person.age = 30;
        person.sayHello("王思聪",20);

        System.out.println(person);// 地址值
    }
}
