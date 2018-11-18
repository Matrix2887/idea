package cn.gandan.service;

import cn.gandan.domain.User;

import java.util.List;

public interface UserService {

    abstract List<User> findAll();

    abstract User findById(int id);

}
