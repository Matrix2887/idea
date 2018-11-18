package cn.gandan.day13.demo11;

public class Demo {
    public static void main(String[] args) {

        int[] arr = createArray(7, (len) -> {
            return new int[len];
        });
        System.out.println(arr.length);
        int[] array = createArray(5, int[]::new);
        System.out.println(array.length);

    }

    public static int[] createArray(int length,ArrayBuilder ab){
        int[] ints = ab.builderArray(length);
        return ints;
    }
}
