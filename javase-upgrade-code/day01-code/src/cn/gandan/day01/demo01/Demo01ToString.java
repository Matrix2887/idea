package cn.gandan.day01.demo01;

/*
    Java.lang.Object
    类Object是类层次结构的根(父)类
    每个类(Person,Student...)都使用Object作为超(父)类
    所有对象(包括数组)都实现这个类的方法
 */
public class Demo01ToString {
    public static void main(String[] args) {

        // Person类默认继承了Object类,所以可以使用Object类中的toString方法
        // String toString()返回该对象的字符串表示

        Person p = new Person("哈曼",18);
        String str = p.toString();
        //  cn.gandan.day01.demo01.Person@75412c2f
        System.out.println(str);

        // 直接打印对象的名字,其实就是调用对象的toString方法
        // cn.gandan.day01.demo01.Person@75412c2f
        // p = p.toString
        System.out.println(p/*.toString*/);

        // 看一个类是否重写了toString方法,直接打印这个类的对象即可
        // 如果没有重写toString方法那么打印的是对象的地址值
    }
}
