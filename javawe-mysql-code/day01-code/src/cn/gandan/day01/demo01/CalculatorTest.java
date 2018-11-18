package cn.gandan.day01.demo01;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result = c.add(1,2);
        System.out.println(result);

        int r = c.sub(1, 1);
        System.out.println(r);
    }
}
