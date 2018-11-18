package cn.gandan.day05.demo01;

/*
    异常的产生过程解析(分析异常是怎么产生的,如何处理异常)
    ArrayIndexOutOfBoundsException: 3
    JVM接收到了这个异常对象,做了两件事情
        1.把异常对象(内容,原因,位置)以红色的字体打印在控制台
        2.JVM会终止当前正在执行的java程序-->中断处理
 */
public class Demo02Exception {
    /*
        ArrayIndexOutOfBoundsException: 3
        main方法接收到了这个异常对象,main方法也没有异常的处理逻辑继续把对象抛出给main方法的调用者JVM处理
     */
    public static void main(String[] args) {
        // 创建int类型的数组,并赋值
        int[] arr = {1,2,3};
        int e = getElement(arr,3);
        System.out.println(e);
    }

    /*
        定义一个方法,获取数组指定索引处的元素
        参数:
            int[] arr
            int index
        访问了数组中的3索引,而数组是没有3索引的,这时候jvm就会检测出程序会异常
        JVM会做两件事情:
            1.JVM会根据异常产生的原因创建一个异常对象,这个异常对象包含了异常产生的(内容,原因,位置)
                ArrayIndexOutOfBoundsException: 3
            2.在getElement方法中,没有异常的处理逻辑(try...catch),那么JVM就会把异常对象抛出给方法的调用者main方法来处理这个异常
     */
    public static int getElement(int[] arr,int index) {
        int ele = arr[index];
        return ele;
    }
}
