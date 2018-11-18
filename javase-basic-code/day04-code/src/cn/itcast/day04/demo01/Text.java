package cn.itcast.day04.demo01;

import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        int travel = 25;
        int list = 2 * travel;
        int sum = travel * list * 2;
        int count = 0;
        int middle = list / 2 + 1;
        for (int i = 1 ; i <= sum; i++) {
            int left = middle - count;
            int right = middle + count;
            if (i % list == 1 && i != 1) {
            System.out.println();
            middle = list + middle;
            if(i <= sum / 2){
                count++;
            }else{
                count--;
            }
        }if (i >= left && i <= right){
            System.out.print('^');
        }else{
            System.out.print(' ');
        }
        }
    }
}