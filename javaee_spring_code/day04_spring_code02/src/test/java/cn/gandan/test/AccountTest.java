package cn.gandan.test;

import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {

    @Test
    public void transfer() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = ac.getBean("accountService", AccountService.class);

       as.transfer("bbb","ccc",100F);

    }

}
