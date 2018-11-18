package cn.gandan.service;

import cn.gandan.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {

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
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    abstract void transfer(String sourceName, String targetName, Float money);

}
