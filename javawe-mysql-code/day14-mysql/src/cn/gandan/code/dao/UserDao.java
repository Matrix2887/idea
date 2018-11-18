package cn.gandan.code.dao;

import cn.gandan.code.domain.User;
import cn.gandan.code.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    private JdbcTemplate  template = new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User loginUser) {
       try {
           String mysql = "SELECT * FROM user WHERE username=? AND password=?";
           String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";

           User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                   loginUser.getUsername(),
                   loginUser.getPassword());
           return user;
       } catch (DataAccessException e) {
           e.printStackTrace();
           return null;
       }
   }
}
