package cn.gandan.dao.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.dbassit.DBAssit;
import cn.gandan.domain.Account;
import cn.gandan.handler.impl.BeanHandler;
import cn.gandan.utils.C3P0Util;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource());

    public void save(Account account) {

        dbAssit.update("insert into stu(name) values(?)", account.getName());

    }

    public void update(Account account) {

        dbAssit.update("update stu set name = ? where id = ?", account.getName(), account.getId());

    }

    public void delete(Integer id) {

        dbAssit.update("delete from stu where id = ?", id);

    }

    public Account findById(Integer id) {
        return (Account) dbAssit.query("select * from stu where id = ?", new BeanHandler(Account.class), id);
    }

    public List<Account> findAll() {
        return null;
    }
}
