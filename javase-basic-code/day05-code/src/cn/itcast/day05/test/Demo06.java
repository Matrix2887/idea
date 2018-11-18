package cn.itcast.day05.test;

/*
定义整数类型数组,数组内存储如下元素:0,1,2,3,4,5,6,7,8,9
将数组内元素进行交换,交换规则如下:1索引元素和0索引元素进行交换,2索引元素和1索引元素进行交换...9索引元素和8索引元素进行交换(不允许直接手动给出索引进行交换)
结果如下:
原数组:[0,1,2,3,4,5,6,7,8,9]
交换后数组:[1,2,3,4,5,6,7,8,9,0]
 */
public class Demo06 {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (i < array.length-1){
                array[i-1] = array[i];
            }else{
                array[i-1] = array[i];
                array[i] = temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
