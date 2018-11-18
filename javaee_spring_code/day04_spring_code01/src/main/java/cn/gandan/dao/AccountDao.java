package cn.gandan.dao;

import cn.gandan.domain.Account;

public interface AccountDao {

    abstract Account findById(Integer id);

}
