package cn.itcast.day07.demo05;

public class Student {
    private int id;
    private String name;
    private int age;
    private static int idCount = 0;

    public Student() {
    }


    public Student(String name, int aged) {
        this.name = name;
        this.age = aged;
        this.id = ++idCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
