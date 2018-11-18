package cn.itcast.day05.demo03;

public class Deno06ArrayMin {
    public static void main(String[] args) {
        int[] array = {-5,-2,-5,-3,-15,-5,-4,-5,-4,-54,-68,-23,1,-51,-613,-13,-51};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]){
                max = max;
            }
            else{
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
