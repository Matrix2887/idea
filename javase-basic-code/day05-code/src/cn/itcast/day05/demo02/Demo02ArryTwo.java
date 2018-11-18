package cn.itcast.day05.demo02;
/*
09 09 09 09 09 09
 */
public class Demo02ArryTwo {

    public static void main(String[] args) {
        int[]arrayA = new int[3];// 动态初始值
        System.out.println(arrayA);// 地址值
        System.out.println(arrayA[0]);// 0
        System.out.println(arrayA[1]);// 0
        System.out.println(arrayA[2]);// 0
        System.out.println("===========");

        // 改变数组当中元素的内容
        arrayA[1] = 10;
        arrayA[2] = 20;
        System.out.println(arrayA);// 地址值
        System.out.println(arrayA[0]);// 0
        System.out.println(arrayA[1]);// 10
        System.out.println(arrayA[2]);// 20


        int[]arrayB = new int[3];// 动态初始值
        System.out.println(arrayB);// 地址值
        System.out.println(arrayB[0]);// 0
        System.out.println(arrayB[1]);// 0
        System.out.println(arrayB[2]);// 0
        System.out.println("===========");

        // 改变数组当中元素的内容
        arrayB[1] = 100;
        arrayB[2] = 200;
        System.out.println(arrayB);// 地址值
        System.out.println(arrayB[0]);// 0
        System.out.println(arrayB[1]);// 100
        System.out.println(arrayB[2]);// 200
    }
}
