package cn.gandan.day06.demo02;

import cn.gandan.day06.demo02.MyThread;

/*

 */
public class Demo01GetThreadName {
    public static void main(String[] args) {

        // 开启多线程
        MyThread mt = new MyThread();
        mt.setName("飘断雕");
        mt.start();
        
        // 开启多线程
        new MyThread("庐初樰").start();
    }
}
