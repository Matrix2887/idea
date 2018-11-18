package cn.gandan.dao;

import cn.gandan.domain.User;

public interface UserDao {
    void addUser(User user);

    boolean exist(String name);

    User login(User user);
}
