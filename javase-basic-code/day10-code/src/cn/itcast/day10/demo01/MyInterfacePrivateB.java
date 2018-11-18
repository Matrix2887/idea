package cn.itcast.day10.demo01;

public interface MyInterfacePrivateB {

    public static void methodStatic1(){
        System.out.println("静态方法1");
        methodStaticCommom();
    }

    public static void methodStatic2(){
        System.out.println("静态方法2");
       methodStaticCommom();
    }

    private static void methodStaticCommom(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }

}
