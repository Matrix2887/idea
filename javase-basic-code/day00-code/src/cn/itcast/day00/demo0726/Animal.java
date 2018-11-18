package cn.itcast.day00.demo0726;

/*(1)定义抽象类Animal,定义抽象方法sleep,
        (2)定义接口fly,定义抽象方法flyInSky
        (3)定义Cat类,继承Animal,重写方法("趴着睡"),定义特有方法catchMouse,打印"抓老鼠"
        (4)定义Duck类,继承Animal,重写方法("漂着睡"),定义特有方法fly,传递接口fly,打印"大鹏展翅"
        (5)定义Feeder类,定义方法feed,传递Animal参数,根据传递的动物,调用动物的sleep方法及特有方法
        (6)定义测试类进行测试*/
public abstract class Animal {
    public abstract void sleep();

}
