package cn.gandan.dao;

import cn.gandan.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    abstract List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    abstract Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    abstract void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    abstract void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    abstract void deleteAccount(Integer acccountId);

    /**
     * 根据姓名查询
     * @param accountName
     * @return
     */
    abstract Account findByName(String accountName);
}
