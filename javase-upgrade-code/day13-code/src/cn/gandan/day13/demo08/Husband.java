package cn.gandan.day13.demo08;

public class Husband {
    public static void main(String[] args) {
        new Husband().buyHouse();
    }


    public void buyHouse(){
        System.out.println("日本东京摩天别墅");
    }
    public void marry(Richable r){
        r.buy();
    }
    public void happy(){
        marry(this::buyHouse);
    }
}
