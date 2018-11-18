package cn.gandan.service.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public Account findById(Integer id) {

        return accountDao.findById(id);

    }

    public void transfer(String sourceName, String targetName, Float money) {

        // 1.根据名称查询转出账户
        Account source = accountDao.findByName(sourceName);
        // 2.根据名称查询转入账户
        Account target = accountDao.findByName(targetName);
        // 3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 4.转入账户加钱
        target.setMoney(target.getMoney() + money);

        accountDao.updateAccount(source);

        accountDao.updateAccount(target);

        //int i = 1/0;

    }
}
