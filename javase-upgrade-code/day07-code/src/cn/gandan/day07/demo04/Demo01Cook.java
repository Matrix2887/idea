package cn.gandan.day07.demo04;

public class Demo01Cook {
    public static void main(String[] args) {

        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃");
            }
        });
        invokeCook(() -> System.out.println("吃饭"));


        invokeCook(() ->{
            System.out.println("吃");
        });

    }



    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
