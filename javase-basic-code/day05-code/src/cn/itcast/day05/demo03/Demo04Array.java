package cn.itcast.day05.demo03;
/*
遍历数组，说的就是对数组当中的每一个元素进行逐一、挨个处理。默认的处理方式就是打印输出。

 */
public class Demo04Array {
    public static void main(String[] args) {
        int[] array = {10,235,54,54,1,25,31,5,656,48,484,54,6,464,646,466,46,46};
        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.println(array[i]);
        }
        System.out.println("============");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        }
    }
