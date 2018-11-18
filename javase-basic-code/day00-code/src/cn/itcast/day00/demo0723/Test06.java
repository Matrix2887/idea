package cn.itcast.day00.demo0723;

import java.util.ArrayList;
import java.util.Arrays;

/*
字符串数组strs中包含字符串{"12","345","6789","1","123","4567"} ，创建2个ArrayList集合 ，分别存放strs数组中字符串长度为偶数的元素和字符串长度为奇数的元素 ，最终将这两个集合在控制台打印输出 ：
打印格式如下：
偶数长度字符串[12,6789,4567]
奇数长度字符串[345,1,123]

 */
public class Test06 {
    public static void main(String[] args) {
        String[] str = {"12","345","6789","1","123","4567"};
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for (int i = 0; i < str.length; i++) {
            if(i % 2 == 0){
               list1.add(str[i]);
            }else{
                list2.add(str[i]);
            }
        }
        System.out.print("偶数长度字符串");
        System.out.println(list1);
        System.out.print("奇数长度字符串");
        System.out.println(list2);
    }
}
