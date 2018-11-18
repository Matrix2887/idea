package cn.gandan.service.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import cn.gandan.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);

    }

    @Override
    public void saveAccount(Account account) {

            // 2.执行操作
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {

            // 2.执行操作
            accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
            // 2.执行操作
            accountDao.deleteAccount(acccountId);
    }

    @Override
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

//            int i = 1/0;

    }
}
