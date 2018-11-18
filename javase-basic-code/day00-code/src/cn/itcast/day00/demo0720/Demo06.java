package cn.itcast.day00.demo0720;

/*
有如下数组int[] arr={10,20,30,40,60,80};
定义一个方法求出数组这元素相加的结果并打印

	1.创建变量sum用来存储当前数组相加的结果
	2.用循环遍历数组。
	3.打印呗，还能咋地
 */
public class Demo06 {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,60,80};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组的和:" + sum);
    }
}
