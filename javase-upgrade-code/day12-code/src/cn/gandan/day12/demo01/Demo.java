package cn.gandan.day12.demo01;

/*
    函数式接口的使用:一般可以作为方法的参数和返回值类型
 */
public class Demo {
    public static void main(String[] args) {
        //调用show方法,方法的参数是一个接口,所以可以传递接口的实现类对象
        show(new MyFunctionalInterfaceImpl());

        //调用show方法,方法的参数是一个接口,所以我们可以传递接口的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        });

        //调用show方法,方法的参数是一个函数式接口,所以我们可以Lambda表达式
        show(()-> {System.out.println("Lambda表达式");});

        //简化Lambda表达式
        show(()-> System.out.println("Lambda表达式简化"));
    }

    //定义一个方法,参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myInter){
        myInter.method();
    }
}
