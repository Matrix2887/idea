package cn.gandan.dao.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl02 implements AccountDao {

    @Autowired
    private JdbcTemplate template;


    public Account findById(Integer id) {
        Account account = template.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return account;
    }

    public void updateAccount(Account account) {
        try{
            template.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String accountName) {
        try{
            List<Account> accounts =  template.query("select * from account where name = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountName);
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
