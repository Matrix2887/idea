package cn.gandan.day08.demo02;

public class Demo03Recurison {
    public static void main(String[] args) {
        int sum = sum(33);
        System.out.println(sum);
        int i = sumSum(1,33);
        System.out.println(i);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n * sum(n - 1);
    }
    public static int sumSum(int a,int b){
        if(a == b){
            return b;
        }
        return a * sumSum(a + 1,b);
    }
}
