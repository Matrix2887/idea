package cn.itcast.day00.demo0720;

/*
使用for循环,求出1-100之间的奇数之和.

	1.首先循环100次
	2.在筛选出奇数
	3.定义一个变量sum用来相加奇数
 */
public class Test {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 1){
                sum += i;
            }
        }
        System.out.println("1-100之间的奇数之和为:" + sum);
    }
}
