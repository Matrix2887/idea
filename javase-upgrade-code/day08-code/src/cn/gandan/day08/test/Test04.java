package cn.gandan.day08.test;
/*第三题：分析以下需求，并用代码实现
        有如下数列(从第三项开始,每一项的值是其前面两项值的和):
        n
        第一项: 1
        第二项: 1
        第三项: 2
        第四项: 3
        第五项: 5
        第六项: 8
        第七项: 13
        第八项: 21
        第九项: 34
        //....
        利用递归计算第20项是多少?
*/
public class Test04 {
    public static void main(String[] args) {
        int sum = getSum(9);
        System.out.println(sum);
    }

    private static int getSum(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return getSum(n - 1) + getSum(n - 2);
    }

}

