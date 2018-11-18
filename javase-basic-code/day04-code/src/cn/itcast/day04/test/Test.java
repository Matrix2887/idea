package cn.itcast.day04.test;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                int result = i * j;
                System.out.print(j + "*" + i + "=" + result + "\t");
            }
            System.out.println();
        }
    }
}
