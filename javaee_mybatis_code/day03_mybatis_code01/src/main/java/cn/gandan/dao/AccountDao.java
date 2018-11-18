package cn.gandan.dao;

import cn.gandan.domain.Account;
import cn.gandan.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    abstract List<Account> findAll();

    abstract List<AccountUser> findUserAll();

}
