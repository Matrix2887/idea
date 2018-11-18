package cn.gandan.dao.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    public Account findById(Integer id) {
        Account account = super.getTemplate().queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return account;
    }
}
