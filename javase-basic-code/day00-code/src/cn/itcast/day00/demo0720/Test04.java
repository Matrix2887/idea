package cn.itcast.day00.demo0720;

/*
已知数组int[] nums = {5,10,15},,要求创建一个新数组
	1.新数组的长度和已知数组相同
	2.新数组每个元素的值 是已知数组对应位置元素的2倍
	3.在控制台中打印新数组的所有元素

	1.既然已经知道数组的个数，就用动态创建数组
	2.用循环把原先数组的元素提取出来，并乘以2倍放入新数组中
	3.遍历打印新数组
 */
public class Test04 {
    public static void main(String[] args) {
        int[] nums = {5,10,15};
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i] * 2;
            System.out.print(newNums[i] + " ");
        }
    }
}
