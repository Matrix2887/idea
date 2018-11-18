package cn.itcast.day10.demo05;

public class Father /*extends Object*/{
    private int num;

    public Father() {
    }

    public Father(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void showNum(){
        System.out.println(num);
    }

    public void method(){
        System.out.println("父类方法");
    }

    public void methodFather(){
        System.out.println("父类特有方法");
    }
}
