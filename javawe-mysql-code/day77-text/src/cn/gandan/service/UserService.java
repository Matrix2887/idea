package cn.gandan.service;

import cn.gandan.domain.User;

public interface UserService {

    abstract void addUser(User user);

    abstract boolean exist(String name);

    abstract User login(User user);
}
