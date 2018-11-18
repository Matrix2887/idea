package cn.itcast.day08.demo02;

import java.util.ArrayList;

/*
题目：
定义一个方法，把数组{1,2,3}按照指定的格式拼接成一个字符串。格式参照如下:[world1#world2#world3]

分析：
1.首先准备一个int[]数组，内容是：1、2、3
2.定义一个方法，用来将数组变成字符串
三要素
返回值类型:String
方法名称:fromArrayToString
参数列表:int[]
3.格式:[world1#world2#world3]
用到:for循环、字符串拼接、每个数组元素之前都有一个world字样、分隔使用的是#、区分一下是不是最后一个
4.调用方法，得到返回值，并打印结果字符串
 */
public class Demo06StringPractise {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        String str = fromArrayToString(array);
        System.out.println(str);
        String str1 = getArrayToString(array);
        System.out.println(str1);
    }
    public  static String  fromArrayToString(int[] array){
        ArrayList<String> list = new ArrayList<>();
        String str1 = "world";
        String str2 = new String();
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                list.add("[" + str1.concat(array[i] + "#"));
            }else if (i < array.length - 1){
                list.add(str1.concat(array[i] + "#"));
            }else{
                list.add(str1.concat(array[i] + "]"));
            }
            }
        for (int j = 0; j < list.size(); j++) {
            str2 = str2.concat(list.get(j));
        }
        return str2;
    }

    public static String getArrayToString(int[] array){
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1){
                str += "world" + array[i] + "]";
            }else{
                str += "world" + array[i] + "#";
            }
        }
        return  str;
    }
}
