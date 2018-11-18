package cn.gandan.dao;

import cn.gandan.domain.User;
import cn.gandan.domain.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    // 获取数据库链接
    private JdbcTemplate  template = new JdbcTemplate(JDBCUtils.getDataSource());

    // 登陆方法
    public User login(User loginUser){

        try {
            // 定义sql的查询语句
            String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";
            // 将查询到的数据封装成对象
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            // 找到数据返回这个数据的对象
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            // 找不到这个数据返回空,好进行判断
            return null;
        }
    }


    public User login(String username,String password){

        try {
            // 定义sql的查询语句
            String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";
            // 将查询到的数据封装成对象
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),
                    username,
                    password);
            // 找到数据返回这个数据的对象
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            // 找不到这个数据返回空,好进行判断
            return null;
        }
    }



}
