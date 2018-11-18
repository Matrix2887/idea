package cn.itcast.day00.demo0720;

/*
分析以下需求并用代码实现：
1.统计整数1-100（包括1和100）之间能同时被3和7整除的数字的个数
2.使用步骤1统计的个数创建该长度的数组
3.使用该数组存储整数1-100（包括1和100）之间能同时被3和7整除的数字
4.遍历数组，打印数组内元素，格式示例如下：
[元素1,元素2，元素3...]

	10.创建变量count用来计数
	20.首先用循环调出1-100，因为知道循环次数，所以用for循环
	30.设置条件，同时模3且模7等于0则计数一次
	40.通过计数变量的值创建数组
	50.在来一次循环用来存储同时被3和7整除的数字
	60.注意这个循环需要两个变量来存储
	70.按照格式打印出数组，第一个和最后一个要注意
 */
public class Test05 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 3 == 0 && i % 7 == 0){
                count++;
            }
        }
        int[] array = new int[count];
        for (int i = 1, j = 0; i <= 100; i++) {
            if(i % 3 == 0 && i % 7 == 0){
                array[j] = i;
                j++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                System.out.print("[" + array[i] + ",");
            }if (i < array.length-1){
                System.out.print(" " + array[i] + ",");
            }else{
                System.out.print(" " + array[i] + "]");
            }
        }
    }
}
