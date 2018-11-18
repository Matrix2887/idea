package cn.gandan.day03.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
根据需求完成代码
	1.定义一个Person类
		成员变量：name   age
		构造方法、get和set、toString
	2.创建三个Person对象
		Person("张三",23);
		Person("李四",24);
		Person("张三",23);
	3.将这三个对象存储到Set集合中。(同姓名同年龄的为重复值、不存储)
	4.使用迭代器遍历集合
 */
public class Test01 {
    public static void main(String[] args) {
        Person p1 = new Person("张三",23);
        Person p2 = new Person("李四",24);
        Person p3 = new Person("张三",23);
        Set<Person> person = new HashSet<>();
        person.add(p1);
        person.add(p2);
        person.add(p3);
        for (Person p : person) {
            System.out.println(p);
        }
    }
}
