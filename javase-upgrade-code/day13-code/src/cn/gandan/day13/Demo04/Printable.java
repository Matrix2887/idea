package cn.gandan.day13.Demo04;

/*
    定义一个打印的函数式接口
 */
@FunctionalInterface
public interface Printable {
    //定义字符串的抽象方法
    abstract void pr(String s);
}
