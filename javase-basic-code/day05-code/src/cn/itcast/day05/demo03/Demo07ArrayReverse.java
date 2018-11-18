package cn.itcast.day05.demo03;
/*
元素反转
之前[1,2,3,4]
之后[4,3,2,1]
不能用新数组，只能用唯一一个。
 */
public class Demo07ArrayReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int num = array.length / 2 - 1;
        int left = 0;
        int right = array.length - 1;
        int temp;
        int temp1;
        int temp2;
        for (int i = 0; i < num; i++) {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left += 1;
            right -= 1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /*
        初始化语句：int min = 0,max = array.length - 1
        条件判断：min > max
        循环体：用三个变量到手
         */
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            temp1 = array[min];
            array[min] = array[max];
            array[max] = temp1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}