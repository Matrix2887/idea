package cn.gandan.day12.demo06;

import java.util.function.Predicate;

/*
    需求:判断一个字符串长度是否大于5
        如果字符串的长度大于5,那返回false
        如果字符串的长度不大于5,那么返回true
    所以我们可以使用取反符号!对判断的结果进行取反

    Predicate接口中有一个方法negate,也表示取反的意思
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }
 */
public class Demo04Predicate_negate {

    public static void main(String[] args) {
        String s = "爆米花就是盛利";

        boolean b = checkString(s,(str)->{
            return str.endsWith("盛利");
        });
        System.out.println(b);
    }


    /*
      定义一个方法,方法的参数,传递一个字符串
      传递两个接口
   */
    public static boolean checkString(String s, Predicate<String> pre1){
//        return !(pre1.test(s));
        return pre1.negate().test(s);
    }
}
