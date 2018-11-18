package cn.gandan.day02.demo03;

/*
泛型:是一种未知的数据类型,当我们不知道使用什么数据类型的时候,可以使用泛型
泛型也可以看出是一个变量,用来接收数据类型

 */
import java.util.ArrayList;
import java.util.Iterator;

public class                  Demo01Generic {
    public static void main(String[] args) {
        listShow();
        genericShow();
    }

    /*
    创建集合对象,使用泛型
    好处:
        1.避免了类型转换的麻烦,存储的是什么类型,取出的就是什么类型
        2.把运行期异常(代码运行之后会抛出的异常)提升到了编译器(写代码的时候会报错)
    弊端:
        泛型是什么类型,只能存储什么类型的数据
     */
    private static void genericShow() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
//        list.add(1);// add(java.lang.String)in ArrayList cannot be applied to (int)

        // 使用迭代器遍历list集合
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s.length());
        }
    }

    /*
    创建集合对象,不使用泛型
    好处:
        集合不使用泛型,默认的类型就是Object类型,可以存储任意类型的数据
    弊端:
        不安全,会引发异常
     */
    private static void listShow() {
        ArrayList list = new ArrayList();
        list.add("abc");
//        list.add(1);
        // 使用迭代器遍历list集合
        Iterator it = list.iterator();
        // 使用迭代器中的方法hasNext和next遍历集合
        while(it.hasNext()){
            // 取出元素也是Object类型
            Object obj = it.next();
            System.out.println(obj);

            // 想要使用String类特有的方法,length获取字符串的长度;不能使用 多态Object obj = "abc";
            // 需要向下转型
            // ClassCastException类型转换异常,不能把Integer类型转换为String类型
            String s = (String) obj;
            System.out.println(s.length());
        }
    }
}
