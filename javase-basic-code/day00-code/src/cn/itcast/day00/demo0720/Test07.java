package cn.itcast.day00.demo0720;

/*
方法的练习：
1.求两个数据之和(整数和小数)
2.判断两个数据是否相等(整数和小数)
3.获取两个数中较大的值(整数和小数)并返回
4.获取两个数中较小的值(整数和小数)并返回
5.否能用一个方法实现3和4的两个功能

    05.整数小数可以用方法重载。
	10.创建一个int方法sum求和，返回然后打印
	20.创建一个boolean方法same，用==判断，返回然后打印
	30.创建一个int方法big，用三元运算判断，返回然后打印
	40.创建一个int方法small，用三元运算判断，返回然后打印
	50.创建一个int[] 方法smallAndBig，先创建长度为2的数组，然后返回取出元素
 */
public class Test07 {
    public static void main(String[] args) {
        double a = 10.5;
        double b = 5.3;
        double c = 10.5;
        double d = 10;
        System.out.println("和" + sum(c,d));
        System.out.println("==========");
        System.out.println("和" + sum(a,b));
        System.out.println("==========");
        System.out.println("是否相同" + same(c,d));
        System.out.println("==========");
        System.out.println("是否相同" + same(a,b));
        System.out.println("==========");
        System.out.println("最大" + big(c,d));
        System.out.println("==========");
        System.out.println("最大" + big(a,b));
        System.out.println("==========");
        System.out.println("最小" + small(c,d));
        System.out.println("==========");
        System.out.println("最小" + small(a,b));
        System.out.println("==========");
        System.out.println("最大" + smallAndBig(c,d)[0] + " " + "最小" + smallAndBig(c,d)[1]);
        System.out.println("==========");
        System.out.println("最大" + smallAndBig(a,b)[0] + " " + "最小" + smallAndBig(a,b)[1]);
    }

//    public static int sum(int a,int b){
//        int result = a + b;
//        return result;
//    }
    public static double sum(double a,double b){
        double result = a + b;
        return result;
    }
//    public static boolean same(int a,int b){
//        return a == b;
//    }
    public static boolean same(double a,double b){
        return a == b;
    }
//    public static int big(int a,int b){
//        int max = a > b ? a : b;
//        return max;
//    }
    public static double big(double a,double b){
        double max = a > b ? a : b;
        return max;
    }
//    public static int small(int a,int b){
//        int min = a < b ? a : b;
//        return min;
//    }
    public static double small(double a,double b){
        double min = a < b ? a : b;
        return min;
    }
//    public static int[] smallAndBig(int a,int b){
//        int[] array = new int[2];
//        if(a > b){
//            array[0] = a;
//            array[1] = b;
//        }else{
//            array[0] = b;
//            array[1] = a;
//        }
//        return array;
//    }
    public static double[] smallAndBig(double a,double b){
        double[] array = new double[2];
        if(a > b){
            array[0] = a;
            array[1] = b;
        }else{
            array[0] = b;
            array[1] = a;
        }
        return array;
    }
}
