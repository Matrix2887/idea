package cn.gandan.day16.mysql.text;


import cn.gandan.day16.mysql.dao.UserDao;
import cn.gandan.day16.mysql.domain.User;
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