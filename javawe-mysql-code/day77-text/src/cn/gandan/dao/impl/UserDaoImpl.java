package cn.gandan.dao.impl;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;
import cn.gandan.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO user values(null,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getPassword(),user.getAge(),user.getHobby(),user.getAddress());

    }

    @Override
    public boolean exist(String name) {
        String sql = "SELECT count(id) FROM user WHERE user = ?";
        Integer i = template.queryForObject(sql,Integer.class,name);
        if(i == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        String sql = "SELECT * FROM user where user = ? and password = ?";

        try {
            User u = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getName(), user.getPassword());
            return u;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
