package cn.gandan.test;

import cn.gandan.dao.UserDao;
import cn.gandan.dao.impl.UserDaoImpl;
import cn.gandan.domain.User;
import org.junit.Test;

import java.util.List;

public class MySqlTest {

    @Test
    public void finaAll() throws Exception {
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
