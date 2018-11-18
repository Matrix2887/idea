package cn.gandan.service;

import cn.gandan.domain.Account;

import java.util.List;

public interface AccountService {

    // 查询所有
    abstract List<Account> findAll();

    // 根据id查询
    abstract Account findById();

    // 保存用户
    abstract void save(Account account);

}
