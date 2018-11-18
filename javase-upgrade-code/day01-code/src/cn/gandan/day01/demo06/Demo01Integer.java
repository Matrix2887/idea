package cn.gandan.day01.demo06;

/*
    装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
        构造方法:
            Integer(int value) 构造一个新分配的Integer 对象,它表示指定的int值
            Integer(String s)  构造一个新分配的Integer 对象,它表示String参数所指示的int值
            传递的字符串,必须是基本类型的字符串,否则会抛出异常  比如:"100"正确"a"异常
        静态方法:
            static Integer valueOf(int i)返回一个表示指定的int值的Integer实例
            static Integer valueOf(String s)返回保存指定的String的值的Integer对象
        拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)

        成员方法:
            int intValue() 以int类型返回该Integer的值
 */
public class Demo01Integer {
    public static void main(String[] args) {
        // 装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
        // 构造方法
        Integer i = new Integer(1);// 方法上有横线,说明方法过时了
        System.out.println(i);// 1重写了toString方法

        Integer i1 = new Integer("2");
        System.out.println(i1);// 1

        // 静态方法
        Integer i2 = Integer.valueOf(3);
        System.out.println(i2);

//        Integer i3 = Integer.valueOf("a");// NumberFormatException数字格式化异常
        Integer i3 = Integer.valueOf("4");
        System.out.println(i3);

        // 拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)
        int n = i.intValue();
        System.out.println(n);

    }
}
