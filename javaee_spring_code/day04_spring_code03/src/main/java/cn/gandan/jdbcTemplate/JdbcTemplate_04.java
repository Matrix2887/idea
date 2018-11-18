package cn.gandan.jdbcTemplate;

import cn.gandan.dao.impl.AccountDaoImpl;
import cn.gandan.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplate_04 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean");

        AccountDaoImpl template = ac.getBean("accountDao", AccountDaoImpl.class);

        Account account = template.findById(5);

        System.out.println(account);

    }

}
