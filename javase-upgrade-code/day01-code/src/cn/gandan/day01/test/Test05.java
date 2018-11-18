package cn.gandan.day01.test;

import java.util.Arrays;

/*
分析以下需求，并用代码实现：
		(1)打印由三个数组成的三位数，要求该三位数中任意两位数字不能相同；
		(2)打印格式最后的三位数字以空格分隔，如789 798 879 897 978 987。
    注：要求使用StringBuilder来完成
 */
public class Test05 {
    public static void main(String[] args) {
        String str = "789";
        for (int i = 100; i <= 999; i++) {
            if(str.equals(sort(i))){
                System.out.print(i + " ");
            }
            }
        System.out.println();
        }
    public static String sort(int i) {
        String n = i + "";
        char[] ch = n.toCharArray();
        Arrays.sort(ch);
        String m = new String(ch);
        return m;
    }
}
