package cn.gandan.service.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    public Account findById(Integer id) {

        return accountDao.findById(id);

    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
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
