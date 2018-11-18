package cn.gandan.day08.test;

/*
    使用递归计算1-5的阶乘
 */
public class Test02 {
    public static void main(String[] args) {
        int result = result(30);
        System.out.println(result);
    }

    private static int result(int i) {
        if(i == 1){
            return 1;
        }
        return i * result(i - 1);
    }
}
