package cn.gandan.service.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import cn.gandan.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */

public class CopeAccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    private TransactionManager tManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void settManager(TransactionManager tManager) {
        this.tManager = tManager;
    }

    @Override
    public List<Account> findAllAccount() {

        try {
            // 1.开启事务
            tManager.beginTransaction();
            // 2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3.提交事务
            tManager.commit();
            // 4.返回结果
            return accounts;
        } catch (Exception e) {
            // 5.回滚操作
            tManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            tManager.release();
        }

    }

    @Override
    public Account findAccountById(Integer accountId) {

        try {
            // 1.开启事务
            tManager.beginTransaction();
            // 2.执行操作
            Account account = accountDao.findAccountById(accountId);
            // 3.提交事务
            tManager.commit();
            // 4.返回结果
            return account;
        } catch (Exception e) {
            // 5.回滚操作
            tManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            tManager.release();
        }

    }

    @Override
    public void saveAccount(Account account) {

        try {
            // 1.开启事务
            tManager.beginTransaction();
            // 2.执行操作
            accountDao.saveAccount(account);
            // 3.提交事务
            tManager.commit();
        } catch (Exception e) {
            // 5.回滚操作
            tManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            tManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {

        try {
            // 1.开启事务
            tManager.beginTransaction();
            // 2.执行操作
            accountDao.updateAccount(account);
            // 3.提交事务
            tManager.commit();
        } catch (Exception e) {
            // 5.回滚操作
            tManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            tManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {

        try {
            // 1.开启事务
            tManager.beginTransaction();
            // 2.执行操作
            accountDao.deleteAccount(acccountId);
            // 3.提交事务
            tManager.commit();
        } catch (Exception e) {
            // 5.回滚操作
            tManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            tManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        try {
            // 1.开启事务
            tManager.beginTransaction();
            // 2.执行操作

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
            // 3.提交事务
            tManager.commit();

//            int i = 1/0;
        } catch (Exception e) {
            // 5.回滚操作
            tManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            tManager.release();
        }

    }
}
