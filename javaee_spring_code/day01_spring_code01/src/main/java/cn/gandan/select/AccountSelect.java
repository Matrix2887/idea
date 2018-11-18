package cn.gandan.select;

import cn.gandan.dao.AccountDao;
import cn.gandan.factory.BeanFactory;
import cn.gandan.service.AccountService;
import cn.gandan.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountSelect {
    public static void main(String[] args) {

//        AccountService as = new AccountServiceImpl();

//        AccountService as =(AccountService) BeanFactory.getBean("accountService");


        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountServiceImpl as = (AccountServiceImpl) ac.getBean("accountService");

        as.show();

    }
}
