package cn.gandan.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    private TransactionManager tManager;

    public void settManager(TransactionManager tManager) {
        this.tManager = tManager;
    }

    public Object around(ProceedingJoinPoint pjp){

        Object rtValue = null;

        try {
            Object[] args = pjp.getArgs();

            System.out.println("logger执行,盛利来了");

            tManager.beginTransaction();

            rtValue = pjp.proceed(args);

            tManager.commit();

            System.out.println("盛利成功执行");

            return rtValue;

        } catch (Throwable throwable) {
            System.out.println("盛利发现一个错误");
            tManager.rollback();
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("盛利结束连接");
            tManager.release();
        }

    }

}
