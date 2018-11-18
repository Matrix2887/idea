package cn.gandan.day02.demo03;

public class Demo02GenericClass {
    public static void main(String[] args) {
        // 不写泛型默认为Object类型
        GenericClass gc = new GenericClass();
        gc.setName("字符串");
        Object obj = gc.getName();

        // 创建GenericClass对象,泛型使用Integer类型
        GenericClass<Integer> g = new GenericClass<>();
        g.setName(1);
        Integer n = g.getName();
        System.out.println(n);

        // 创建GenericClass对象,泛型使用String类型
        GenericClass<String> c = new GenericClass<>();
        c.setName("艾登.皮尔斯");
        String s = c.getName();
        System.out.println(s);
    }
}
