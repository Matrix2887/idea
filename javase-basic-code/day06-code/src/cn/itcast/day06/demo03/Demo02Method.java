package cn.itcast.day06.demo03;

/*
面向对象三大特征：封装、继承、多态

封装性在Java当中的体现：
1.方法就是一种封装
2.关键字private也是一种封装

封装就是将一些细节信息隐藏起来，对于外界不可见
 */
public class Demo02Method {
    public static void main(String[] args) {
        int[] array1 = {5,15,25,20,100};

        int max = getMax(array1);
        System.out.println("最大值" + max);
    }
    // 给我一个数组，我换给你一个最大值
    public static int getMax(int[] array2){
        int max = array2[0];
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] > max){
                max = array2[i];
            }
        }
        return max;
    }
}
