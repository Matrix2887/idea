package cn.itcast.day09.demo02;

public class Son extends Father {
    int numSon = 20;
    int num = 200;

    public void methodSon(){
        // 因为本类当中有num，所以这里用的是本类的num
        System.out.println(num);
    }
}
