package cn.itcast.day10.demo01;

/*
在任何版本的Java中,接口都能定义抽象方法
格式:
public abstract 返回值类型 方法名称 (参数列表)

注意事项:
1.接口当中的抽象方法,修饰符必须是两个固定的关键字:public abstract
2.这两个关键字修饰符,可以选择性地省略(今天新学,所以不推荐)
3.方法的三要素,可以随意定义

接口使用步骤:
1.接口不能直接使用,必须有一个"实现类"来"实现"该接口
格式:
public class 实现类名称 implements 接口名称{
    //...
}
2.接口的实现类必须覆盖重写(实现)接口中所有的抽象方法
实现:去掉abstract关键字,加上方法体大括号
3.创建实现类的对象,进行使用
 */
public interface MyInterfaceAbstract {

    // 这是一个抽象方法
    public abstract void methodAbs();

    // 这是抽象方法
    abstract void methodAbs1();

    // 这也是抽象方法
    public  void methodAbs2();

    // 这也是抽象方法
    void methodAbs3();
}
