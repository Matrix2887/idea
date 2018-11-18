package cn.gandan.day05.demo02;

import java.util.List;

/*
    异常的注意事项
    try中可能会产生的异常对象
    ArrayIndexOutOfBoundsException
    IndexOutOfBoundsException
    try中如果出现了异常对象,会把异常对象抛出给catch处理
    抛出的异常对象,会从上到下依次赋值给catch中定义的异常变量
 */
public class Demo03Exception {
    public static void main(String[] args) {
        /*
        多个异常使用捕获该如何处理
        1.多个异常分别处理
        2.多个异常一次捕获,多次处理
        3.多个异常一次捕获一次处理
         */
        // 1.多个异常分别处理
//        try{
//            int[] arr = {1,2,3};
//            System.out.println(arr[3]);// ArrayIndexOutOfBoundsException: 3
//
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
//        }
//        try{
//            List<Integer> list = List.of(1,2,3);
//            System.out.println(list.get(3));// IndexOutOfBoundsException
//
//        }catch (IndexOutOfBoundsException e){
//            System.out.println(e);
//        }


        //  2.多个异常一次捕获,多次处理
//        try{
//            int[] arr = {1,2,3};
////            System.out.println(arr[3]);// ArrayIndexOutOfBoundsException: 3
//
//            List<Integer> list = List.of(1,2,3);
//            System.out.println(list.get(3));// IndexOutOfBoundsException
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
//        }catch (IndexOutOfBoundsException e){
//            System.out.println(e);
//        }
//
//        /*
//            一个try多个catch注意事项:
//                catch里边定义的异常变量,如果有子父类关系,那么子类的异常变量必须写在上边否则就会报错
//                ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
//         */
//        try{
//            int[] arr = {1,2,3};
////            System.out.println(arr[3]);// ArrayIndexOutOfBoundsException: 3
//
//            List<Integer> list = List.of(1,2,3);
//            System.out.println(list.get(3));// IndexOutOfBoundsException
//        }catch (IndexOutOfBoundsException e){
//            System.out.println(e);
//        }catch (ArrayIndexOutOfBoundsException e){// 此变量没有被使用
//            System.out.println(e);
//        }

        // 3.多个异常一次捕获一次处理
        try{
            int[] arr = {1,2,3};
//            System.out.println(arr[3]);// ArrayIndexOutOfBoundsException: 3
            List<Integer> list = List.of(1,2,3);
            System.out.println(list.get(3));// IndexOutOfBoundsException
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }

        // 运行时异常抛出可以不处理,即不捕获也不声明抛出
        // 默认给虚拟机处理,终止程序,什么时候不抛出运行时异常了,在来继续执行程序
            int[] arr = {1,2,3};
            System.out.println(arr[3]);// ArrayIndexOutOfBoundsException: 3
            List<Integer> list = List.of(1,2,3);
            System.out.println(list.get(3));// IndexOutOfBoundsException

        System.out.println("后续代码");

    }
}
