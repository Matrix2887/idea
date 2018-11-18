package cn.gandan.dao;

import cn.gandan.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws Exception;
}
