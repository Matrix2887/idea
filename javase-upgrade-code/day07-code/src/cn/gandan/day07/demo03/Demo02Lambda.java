package cn.gandan.day07.demo03;

public class Demo02Lambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3 + Thread.currentThread().toString());
            }
        }).start();

        new Thread(() ->{
                System.out.println(4 + Thread.currentThread().toString());
            }
        ).start();

        new Thread(() ->
            System.out.println(4 + Thread.currentThread().toString())
            ).start();
    }
}
