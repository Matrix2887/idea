package cn.itcast.day11.demo01;

/*
final关键字代表最终,不可改变的

常见四种用法:
1.可以用来修饰一个类
2.可以用来修饰一个方法
3.还可以用来修饰一个局部变量
4.还可以用来修饰一个成员变量
 */
public class Demo01Final {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);// 10
        num = 20;
        System.out.println(num);// 20

        // 一旦使用final用来修饰局部变量,那么这个变量就不能进行更改
        // "一次赋值,终生不变"
        final int num1 = 200;
        System.out.println(num1);
//        num1 = 250;// 错误写法!不能改变!
//        num1 = 200;// 错误写法!

        // 正确写法!只要保证有唯一一次赋值即可
        final int num2;
        num2 = 30;

        // 对于基本类型来说,不可变说的是变量当中的数据不可改变
        // 对于引用类型来说,不可变说的是变量当中的地址值不可改变

        Student stu = new Student("艾登.皮尔斯");
        System.out.println(stu);
        System.out.println(stu.getName());
        stu = new Student("玛丽.皮尔斯");
        System.out.println(stu);
        System.out.println(stu.getName());
        System.out.println("================");
        final Student stu1 = new Student("麦克.迪圣塔");
        System.out.println(stu1.getName());// 麦克.迪圣塔

        // 错误写法!final的引用类型变量,其中的地址值不可改变
        //        stu1 = new Student("崔佛.菲利普");
        stu1.setName("富兰克林");
        System.out.println(stu1.getName());// 富兰克林
    }
}

