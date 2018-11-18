package cn.itcast.day04.test;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        int travel = 60;
        int list = 2 * travel;
        int sum = travel * list * 2;
        int count = 0;
        int middle = list / 2 + 1;
        for (int i = 1 ; i <= sum; i++) {
            int left = middle - count;
            int right = middle + count;
            if (i % list == 1 && i != 1) {
                System.out.println('-');
                middle = list + middle;
                if(i <= sum / 2){
                    count++;
                }else{
                    count--;
                }

            }if (i >= left && i <= right){
                System.out.print('O');
            }else{
                System.out.print('-');
            }
        }
    }
}

