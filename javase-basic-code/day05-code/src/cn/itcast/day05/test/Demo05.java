package cn.itcast.day05.test;

/*
1.定义数组,存储1-100(包括1和100)之间所有能被7整除的数字
2.定义方法,传递数组,计算数组元素最大值并将结果返回
3.定义方法,传递数组,计算数组元素最小值并将结果返回
3.定义方法,传递数组及最大值,最小值,将最大值和最小值进行交换,并打印交换后的数组

 */
public class Demo05 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 7 == 0){
                count++;
            }
        }
        int[] array = new int[count];
        for (int i = 1,j = 0; i <= 100; i++) {
            if(i % 7 == 0){
                array[j] = i;
                j++;
            }
        }
        int max = max(array);
        System.out.println("最大值" + max);
        System.out.println("===============");
        int min = min(array);
        System.out.println("最小值" + min);
        System.out.println("===============");
        arrayNum(array,max,min);
    }
    public static int max(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static int min(int[] array){
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static void arrayNum(int[] array,int max,int min){
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(max == array[i]){
                maxIndex = i;
            }
            if(min == array[i]){
                minIndex = i;
            }
        }
        array[maxIndex] = min;
        array[minIndex] = max;
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
