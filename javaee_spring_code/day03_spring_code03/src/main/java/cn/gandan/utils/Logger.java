package cn.gandan.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component("logger")
@Aspect
@ComponentScan("cn.gandan")
@EnableAspectJAutoProxy
public class Logger {

    @Pointcut("execution(* cn.gandan.service.impl.*.*(..))")
    public void pt1(){}

   /* @Before("pt1()")
    public void before(){
        System.out.println("我永远爱");
    }

    @AfterReturning("pt1()")
    public void afterA(){
        System.out.println("不会改变");
    }

    @AfterThrowing("pt1()")
    public void afterB(){
        System.out.println("这不是梦");
    }

    @After("pt1()")
    public void afterC(){
        System.out.println("不会结束");
    }*/

    @Around("pt1()")
    public Object around(ProceedingJoinPoint pjp){

            Object rtValue = null;
        try {

            Object[] args = pjp.getArgs();

            System.out.println("我最爱");
            rtValue = pjp.proceed(args);
            System.out.println("不会改变");

        } catch (Throwable throwable) {
            System.out.println("不会出错");
            throwable.printStackTrace();
        }finally {
            System.out.println("不会结束");
        }

        return rtValue;

    }

}
