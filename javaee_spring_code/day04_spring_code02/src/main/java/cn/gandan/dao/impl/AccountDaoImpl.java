package cn.gandan.dao.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    public Account findById(Integer id) {
        Account account = super.getTemplate().queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return account;
    }

    public void updateAccount(Account account) {
        try{
            super.getTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String accountName) {
        try{
            List<Account> accounts =  super.getTemplate().query("select * from account where name = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            } else if(accounts.size() > 1){
                throw new RuntimeException("结果不为一");
            }else {
                return accounts.get(0);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
