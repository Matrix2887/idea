package cn.itcast.day05.test;

/*
1.定义长度为100的整数类型数组,并对数组进行赋值1-100之间的整数数据(包括1和100),
2.定义方法,传递数组,将数组中元素能同时被3和5整除的存入到新数组中,并将新数组返回
3.定义方法,传递数组及一个整数数据,判断该数据在数组中是否存在,如果存在,则打印该元素在数组中出现的位置,
如果不存在则提示"不存在"
4.定义print方法,打印传递的数组内的元素,打印格式如下:数组元素:[元素1,元素2,元素3...]
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("==============");
        int[] arrayNum = arrayNum(array);
        for (int i = 0; i < arrayNum.length; i++) {
            System.out.print(" " + arrayNum[i]);
        }
        System.out.println();
        System.out.println("==============");
        contains(arrayNum(array),45);
        System.out.println("==============");
        print(arrayNum(array));
    }
    public static int[] arrayNum(int[] array){
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(array[i] % 3 == 0){
                if (array[i] % 5 == 0){
                    count++;
                }
            }
        }
        int[] arrayNum = new int[count];
        for (int i = 0,j = 0; i < 100; i++) {
            if(array[i] % 3 == 0){
                if (array[i] % 5 == 0){
                    arrayNum[j] = array[i];
                    j++;
                }
            }
        }
        return arrayNum;
    }

    public static void contains(int[] array,int a){
        int count = 0;
        int order = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == a){
                count++;
                order = i;
                break;
            }
        }
        switch (count){
            case 0:
                System.out.println("不存在");
                break;
            default:
                System.out.println("索引值是" + order);
                break;
        }
    }

    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                System.out.print("[" + array[i]);
            }else if(i < array.length-1){
                System.out.print(", " + array[i]);
            }else{
                System.out.print(", " + array[i] + "]");
            }
        }
    }
}
