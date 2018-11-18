package cn.itcast.day00.demo0720;

/*
定义一个方法,求出给定的数字在给定int型数组中出现的次数,如果一次没有出现则返回0。
如:给定数字3 求出3在数组 int[] arr = {3,4,3,5,7,9};中出现的次数

	10.首先创建一个int方法，名为count
	20.在方法里创建名为count的int变量
	30.for循环遍历数组，并给出if条件==3，count++
	40.返回count++;
 */
public class Test08 {
    public static void main(String[] args) {
        int[] arr = {3,4,3,5,7,9,3};
        int count = count(arr);
        System.out.println("3在数组出现" + count + "次");
    }
    public static int count(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 3){
                count++;
            }
        }
        return count;
    }
}
