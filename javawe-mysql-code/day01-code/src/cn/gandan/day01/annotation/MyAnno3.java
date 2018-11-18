package cn.gandan.day01.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})// 表示该注解只能作用于类上
public @interface MyAnno3 {
}
