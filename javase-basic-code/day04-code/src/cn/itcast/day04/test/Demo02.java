package cn.itcast.day04.test;

public class Demo02 {
    public static void main(String[] args) {
        int ge;
        int shi;
        int bai;
        int qian;
        int count = 0;
        for (int i = 9999; i >= 1000; i--) {
            ge  = i % 10;
            shi = i / 10 % 10;
            bai = i / 100 % 10;
            qian = i / 1000 % 10;
            if (ge + bai == shi + qian ){
                count++;
                System.out.print(i + "\t");
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println(count);
    }
}