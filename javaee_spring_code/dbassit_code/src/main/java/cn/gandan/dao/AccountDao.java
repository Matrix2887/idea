package cn.gandan.dao;

import cn.gandan.domain.Account;

import java.util.List;

public interface AccountDao {

    abstract void save(Account account);

    abstract void update(Account account);

    abstract void delete(Integer id);

    abstract Account findById(Integer id);

    abstract List<Account> findAll();

}
