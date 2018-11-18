package cn.itcast.day05.test;

/*
1.定义一个int类型数组,包含以下数据,12,25,36,45,78,96,121,456,0,7
2.定义print方法,传递数组,打印数组内所有元素,打印格式如下:
数组元素:[12,25,36,45,78,96,121,456,0,7]
3.定义getSum方法,传递数组,计算数组内元素和,并将结果返回
4.定义getAvg方法,传递数组及总和,计算平均值并返回
5.定义findNum方法,传递数字及平均值,打印小于平均值的元素.
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] array = {12,25,36,45,78,96,121,456,0,7};
        print(array);
        System.out.println();
        System.out.println("=================");
        int sum = getSum(array);
        System.out.println("和为:" + sum);
        System.out.println("=================");
        double avg = getAvg(array);
        System.out.println("平均值为:" + avg);
        System.out.println("=================");
        findNum(array);
    }
    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                System.out.print("数组元素[" + array[i]);
            }else if(i < array.length - 1){
                System.out.print(", " + array[i]);
            }else{
                System.out.print(", " + array[i] + "]");
            }

        }
    }

    public static int getSum(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double getAvg(int[] array){
        if(array.length == 0){
            System.out.println("数组的长度不能为0");
            return 0.0;
        }
        double sum = getSum(array);
        double avg= sum / array.length;
        return avg;
    }

    public static void findNum(int[] array){
        double avg = getAvg(array);
        System.out.print("小于平均值:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < avg){
                System.out.print(" " + array[i]);
            }
        }
    }
}
