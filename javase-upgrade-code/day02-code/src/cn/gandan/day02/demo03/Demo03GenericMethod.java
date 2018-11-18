package cn.gandan.day02.demo03;

/*
    测试含有泛型的方法
 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        // 创建GenericMethod对象
        GenericMethod gm = new GenericMethod();

        // 调用含有泛型的方法method
        // 传递什么类型,泛型就是什么类型
        gm.method(10);
        gm.method("abc");
        gm.method(8.2);
        gm.method('A');
        gm.method(true);


        gm.methodStatic("静态方法不建议创建对象调用");

        // 静态方法,通过类名.方法名(参数)可以直接使用
        GenericMethod.methodStatic("静态方法");
        GenericMethod.methodStatic(233);
    }
}
