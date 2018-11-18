package cn.gandan.day01.demo01;

public class Demo02Equals {
    public static void main(String[] args) {
/*
    Person类默认继承了Object类,所以可以使用Object类的equals方法
    boolean equals(Object obj) 指示其他某个对象是否与此对象"相等"
    equals方法源码:
        public boolean equals(Object obj) {
        return (this == obj);
    }
    参数:
    Object obj:可以传递任意的对象
    == 比较运算符,
    基本数据类型:比较的是值
    引用数据类型:比较的是两个对象的地址值
    this 哪个对象调用的方法,方法中的this就是他;pa中this就是pa
    obj就是参数pb
    this == obj --> pa == pb
*/
        Person pa = new Person("哈曼",17);
        Person pb = new Person("拉克丝",20);
        Person pc = new Person("拉克丝",20);
//        pa = pb;
        System.out.println("pa\t" + pa);
        System.out.println("pb\t" + pb);
        System.out.println(pa.equals(pb));
        System.out.println(pc.equals(pb));

    }
}
