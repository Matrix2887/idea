package cn.gandan.service.impl;

import cn.gandan.dao.UserDao;
import cn.gandan.dao.impl.UserDaoImpl;
import cn.gandan.domain.User;
import cn.gandan.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public boolean exist(String name) {
       return userDao.exist(name);
    }

    @Override
    public User login(User user) {
        return null;
    }
}
