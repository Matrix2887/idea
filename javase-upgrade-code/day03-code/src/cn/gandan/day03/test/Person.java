package cn.gandan.day03.test;

import java.util.Objects;

/*
根据需求完成代码
	1.定义一个Person类
		成员变量：name   age
		构造方法、get和set、toSring
	2.创建三个Person对象
		Person("张三",23);
		Person("李四",24);
		Person("张三",23);
	3.将这三个对象存储到Set集合中。(同姓名同年龄的为重复值、不存储)
	4.使用迭代器遍历集合
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
