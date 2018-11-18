package cn.gandan.test.test0809;

import java.util.*;

/*
第四题：分析以下需求，并用代码实现
	1.有如下代码：
		public static void main(String[] args) {
			List<String> list = new ArrayList<>();
			list.add("a");
			list.add("a");
			list.add("c");
			list.add("c");
			list.add("a");
			list.add("d");
		}
	2.定义一个noRepeat()方法,要求对传递过来集合中进行元素去重
		public static void noRepeat(List<String> al){

		}
 */
public class Test04 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("c");
        list.add("a");
        list.add("d");
        noRepeat(list);
    }
    public static void noRepeat(List<String> al){
        Set<String> set = new HashSet<>();
        for (String s : al) {
            set.add(s);
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
