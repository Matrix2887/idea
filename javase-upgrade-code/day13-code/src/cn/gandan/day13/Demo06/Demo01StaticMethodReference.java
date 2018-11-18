package cn.gandan.day13.Demo06;

/*
    通过类名引用静态成员方法

 */
public class Demo01StaticMethodReference {
    public static void main(String[] args) {
        int n = method(-10, (i) -> {
            return Math.abs(i);
        });
        System.out.println(n);
        int method = method(-11,Math::abs);
        System.out.println(method);
    }
    public static int method(int i,Calcable c){
        return c.calsAbs(i);
    }
}
