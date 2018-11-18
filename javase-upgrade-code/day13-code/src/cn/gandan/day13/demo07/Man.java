package cn.gandan.day13.demo07;

public class Man extends Human{
    public static void main(String[] args) {
        new Man().show();
    }

    @Override
    public void sayHello() {
        System.out.println("盛利");
    }


    public void method(Greetable g){
        g.greet();
    }

    public void show(){
//        method(()->{
//            Human h = new Human();
//            h.sayHello();
//        });
//        super.sayHello();

        method(super::sayHello);

    }
}
