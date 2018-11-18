package cn.gandan.day02.demo03;

/*
    测试含有泛型的接口
 */
public class Demo04GenericInterface {
    public static void main(String[] args) {
        // 创建GenericInterfaceImpl1对象
        GenericInterfaceImpl1 gi = new GenericInterfaceImpl1();
        gi.method("字符串");

        // 创建GenericInterfaceImpl2对象
        GenericInterfaceImpl2<Integer> g = new GenericInterfaceImpl2<>();
        g.method(10);

        GenericInterfaceImpl2<Double> g3 = new GenericInterfaceImpl2<>();
        g3.method(8.8);
    }
}
