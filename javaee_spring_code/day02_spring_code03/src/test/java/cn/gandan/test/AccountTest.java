package cn.gandan.test;

import cn.gandan.config.SpringConfig;
import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {

    @Test
    public void findAll() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService as = ac.getBean("accountService", AccountService.class);

        List<Account> accounts = as.findAllAccount();

        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void findById() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService as = ac.getBean("accountService", AccountService.class);

        Account accountById = as.findAccountById(1);

        System.out.println(accountById);

    }

    @Test
    public void save() {

        Account account = new Account();

        account.setName("盛利");

        account.setMoney(520F);

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService as = ac.getBean("accountService", AccountService.class);

        as.saveAccount(account);

    }

    @Test
    public void update() {

        Account account = new Account();

        account.setId(1);
        account.setMoney(1314F);
        account.setName("爆米花");

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService as = ac.getBean("accountService", AccountService.class);

        as.updateAccount(account);

    }

    @Test
    public void delete() {

    }
}
