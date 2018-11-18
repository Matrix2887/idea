package cn.gandan.day01.annotation;

/*
    属性的返回值类型
    String
    枚举
    注解
    以上类型的数组
 */
public @interface MyAnno {

    // 如果只有value需要赋值,那么value可以省略直接操作
    abstract int value();

    // 给属性默认初始化时,使用注解不用赋予属性值
    abstract String name()default "盛利";

    abstract MyAnno2 anon2();

    abstract Person per();

    // 如果数组只有一个值那么大括号可以省略
    abstract int[] strs();

}
