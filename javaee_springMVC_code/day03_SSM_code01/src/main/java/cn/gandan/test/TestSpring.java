package cn.gandan.test;

import cn.gandan.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {


    @Test
    public void testService(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountService as = ac.getBean("accountService", AccountService.class);

        as.findAll();

        as.findById();

    }

}
