package cn.gandan.service.impl;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;
import cn.gandan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(int id) {
        return null;
    }
}
