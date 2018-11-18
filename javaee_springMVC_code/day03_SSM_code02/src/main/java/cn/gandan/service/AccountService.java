package cn.gandan.service;

import cn.gandan.domain.Account;

import java.util.List;

public interface AccountService {

    abstract List<Account> findAll();

    abstract void save(Account account);

}
