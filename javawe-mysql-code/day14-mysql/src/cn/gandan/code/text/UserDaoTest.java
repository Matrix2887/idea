package cn.gandan.code.text;

import cn.gandan.code.dao.UserDao;
import cn.gandan.code.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin1(){
        User loginuser = new User();
        loginuser.setUsername("shengli");
        loginuser.setPassword("123456");

        UserDao userDao = new UserDao();
        User login = userDao.login(loginuser);
        System.out.println(login);
    }
}