package cn.gandan.test;

import cn.gandan.dao.AccountDao;
import cn.gandan.dao.impl.AccountDaoImpl;
import cn.gandan.domain.Account;

public class Test {

    public static void main(String[] args) {
//        Account account = new Account();
//
//        account.setName("盛利利");

        AccountDao accountDao = new AccountDaoImpl();

//        accountDao.save(account);

        Account byId = accountDao.findById(1);

        System.out.println(byId);

    }

}
