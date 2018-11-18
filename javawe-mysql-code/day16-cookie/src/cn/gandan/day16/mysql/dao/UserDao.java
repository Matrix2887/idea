package cn.gandan.day16.mysql.dao;

import cn.gandan.day16.mysql.domain.User;
import cn.gandan.day16.mysql.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User loginUser){
        try {
            String sql = "SELECT * FROM USER WHERE username=? AND password=? ";
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
