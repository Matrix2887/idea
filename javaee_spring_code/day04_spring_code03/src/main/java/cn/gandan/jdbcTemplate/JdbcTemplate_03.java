package cn.gandan.jdbcTemplate;

import cn.gandan.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplate_03 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean");

        JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);

//        template.update("INSERT INTO account (name, money) VALUE ('爆米花花', 5201314)");

//        template.update("UPDATE account SET name = ?, money = ? WHERE id = ?","我爱盛利利", 5201314, 4);

//        template.update("DELETE FROM account WHERE id = ?", 1);

//        List<Account> query = template.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));

        List<Account> query = template.query("select * from account", new AccountRowMapper());

        for (Account account : query) {
            System.out.println(account);
        }

    }

}

class AccountRowMapper implements RowMapper<Account>{

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

        Account account = new Account();

        account.setId(rs.getInt("id"));

        account.setName(rs.getString("name"));

        account.setMoney(rs.getFloat("money"));

        return account;
    }
}
