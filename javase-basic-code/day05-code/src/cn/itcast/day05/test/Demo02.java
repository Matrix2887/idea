package cn.itcast.day05.test;

/*
模拟计算器:
定义三个整数类型变量num1,mark,num2
根据mark的值选择运算类型,
mark值为0,调用getSum方法,计算num1和num2的和并打印;
mark值为1,调用getDifference方法,计算num1和num2的差并打印;
mark值为2,调用getProduct 方法,计算num1和num2的乘积并打印;
mark值为3,调用getQuotient 方法,计算num1和num2的商并打印;
mark值为4,调用getRemainder 方法,计算num1和num2的余数并打印;
如果mark值大于4,则提示"没有这种计算方式"

打印格式如下:例如当mark值为0,num1值为1,num2值为2时打印:
您进行的计算为:加法
表达式及结果:1 + 2 = 3;
 */
public class Demo02 {
    public static void main(String[] args) {
        int mark = 3;
        int num1 = 10;
        int num2 = 0;
        switch(mark){
            case 0:
                int result = getSum(num1,num2);
                System.out.println("" + num1 + "+" + num2 + "=" + result);
                break;

            case 1:
                int result1 = getDifference(num1,num2);
                System.out.println("" + num1 + "-" + num2 + "=" + result1);
                break;

            case 2:
                int result2 = getProduct(num1,num2);
                System.out.println("" + num1 + "*" + num2 + "=" + result2);
                break;

            case 3:
                getQuotient(num1,num2);

                break;

            case 4:
                int result4 = getRemainder(num1,num2);
                System.out.println("" + num1 + "%" + num2 + "=" + result4);
                break;

            default:
                System.out.println("没有这种计算方式");
                break;
        }

    }

    private static int getSum(int a, int b) {
        int sum = a + b;
        return sum;
    }
    private static int getDifference(int a, int b) {
        int difference = a - b;
        return difference;
    }
    private static int getProduct(int a, int b) {
        int product = a * b;
        return product;
    }
    private static void getQuotient(int a, int b) {
        if (b == 0){
            System.out.println("除数不能为0");
            return;
        }else {
            int quotient = a / b;
            System.out.println("" + a + "/" + b + "=" + (a / b));
        }
    }
    private static int getRemainder(int a, int b) {
        int remainder = a % b;
        return remainder;
    }
}
