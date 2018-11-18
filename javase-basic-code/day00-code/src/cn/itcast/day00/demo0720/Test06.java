package cn.itcast.day00.demo0720;

/*
主方法中给定数组int[] arr= {10,20,30,40,50,60};这个数组没有重复元素.
定义一个方法可以接受这个给定的数组并返回这个数组中最大元素值的索引值

	10.首先定义一个int方法，名字为max。参数数组为array
	20.在方法里定义一个int变量max,用来比出数组元素的最大值。
	30.在定义一个int变量maxNum用来接受数组最大值的索引值
	40.返回最大值的索引值。
 */
public class Test06 {
    public static void main(String[] args) {
        int[] arr= {10,20,30,70,50,60};
        int maxNun = max(arr);
        System.out.println("最大值的索引值为" + maxNun);
    }

    public static int max(int[] array){
        int max = array[0];
        int maxNum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
                maxNum = i;
            }
        }
        return maxNum;
    }
}
