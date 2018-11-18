package cn.itcast.day00.demo0726;

/*
1.定义接口Loans(贷款),包含如下内容:
(1)抽象方法:void sendLoans()
(2)默认方法:void check(),要求:输出”查询征信”
2.定义抽象类Bank,要求如下:
包含空参\满参构造\成员变量:银行名称 bankName (String类型)以及set/get方法
抽象方法,void bankCustomer(Person person)
3.定义Person类,包含空参\满参构造\成员变量:姓名name (String类型)以及set/get方法
4.定义类BOC(中国银行)，要求如下：
继承抽象类 Bank，实现接口 Loans(贷款)
 	构造方法包括：空参\满参构造方法(String)
    重写抽象方法：
        void sendLoans()，要求：输出”XXX银行可以发放贷款”
        void void bankCustomer(Person person)，要求：输出打印"YYY使用的是XXX银行的贷款"
PS：YYY是Person类中的 name属性值 ,XXX是Bank类中的 name属性值
5.定义测试类，在main方法实现以下功能：
创建并初始化一个BOC对象bank和一个Person对象 p， 调用bank的 sendLoans()、check()和bankCustomer(Person person)方法
打印示例:
中国银行可以发放贷款
查询征信
张三使用的是中国银行的贷款
 */
public class People {
    private String name;

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

