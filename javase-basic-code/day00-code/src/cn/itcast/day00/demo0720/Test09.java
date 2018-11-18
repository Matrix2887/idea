package cn.itcast.day00.demo0720;

/*
定义一个方法，查找指定数字在数组中出现的位置(若出现多次，多次打印)
如: 数组[1232]要查找的数是2 则方法内部会打印索引值 1 ,3
数组[1232] 要查找的数是5 则会打印 “数组中没有这个数字”

	10.创建一个void方法，名为count,参数为int[] arr
	25.在方法中定义一个int变量count = 0来计算出现次数
	20.在方法中来一个循环，if语句筛选是==2，并在if语句中打印 count++
	30.在循环外面再来判断count 是否等于0，等于就打印 “数组中没有这个数字”
 */
public class Test09 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,8,2,6,4,7,8,5,4,5,8,9,7,4};
        int num = 6;
        count(arr,num);
    }
    public static void count(int[] array,int a){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == a){
                count++;
                System.out.println(a + "索引位置为" + i);
            }
        }
        if(count == 0){
            System.out.println("数组中没有这个数字");
        }
    }
}
