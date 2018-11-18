package cn.gandan.day01.test;

import cn.gandan.day01.demo01.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
    @After
    public void close(){
        System.out.println("我爱爆米花");
    }

    @Before
    public void init(){
        System.out.println("我爱盛利");
    }

    @Test
    public void testAdd(){
//        System.out.println("我爱盛利");
        Calculator c = new Calculator();
        int result = c.add(1, 2);
//        System.out.println(result);
        System.out.println(result);
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int sub = c.sub(2, 1);
        Assert.assertEquals(1,sub);
    }
}
