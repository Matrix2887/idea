package cn.gandan.dao;

import cn.gandan.domain.User;

import java.util.List;

public interface UserDao {


    abstract List<User> findAll();

}
