package cn.gandan.service.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("查询所有");
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
        return accounts;
    }

    @Override
    public Account findById() {

        System.out.println("查询单个");
        Account account = accountDao.findById();
        System.out.println(account);
        return account;
    }

    @Override
    public void save(Account account) {
        System.out.println("保存用户");
        accountDao.save(account);
    }
}
