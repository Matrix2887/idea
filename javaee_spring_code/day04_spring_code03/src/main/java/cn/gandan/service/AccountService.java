package cn.gandan.service;

import cn.gandan.domain.Account;

public interface AccountService {


    abstract Account findById(Integer id);

    abstract void transfer(String sourceName, String targetName, Float money);

}
