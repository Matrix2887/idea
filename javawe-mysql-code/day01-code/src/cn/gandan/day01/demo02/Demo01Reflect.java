package cn.gandan.day01.demo02;

import cn.gandan.day01.domain.Person;
import cn.gandan.day01.domain.Student;

public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        // 多用于配置文件,将类名定义在配置文件中.读取文件,加载类
        Class cls1 = Class.forName("cn.gandan.day01.domain.Person");
        System.out.println(cls1);

        // 多用于参数的传递
        Class cls2 = Person.class;
        System.out.println(cls2);

        // 多用于对象的获取字节码的方式
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        System.out.println(cls1=cls2);//true
        System.out.println(cls1==cls3);//true
        System.out.println(cls2==cls3);//true

        // 同一个字节码文件在一次程序过程中,只会被加载一次


        Class c = Student.class;
        System.out.println(c==cls1);

    }
}
