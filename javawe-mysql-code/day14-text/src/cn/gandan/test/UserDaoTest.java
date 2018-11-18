package cn.gandan.test;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin1(){
        User loginuser = new User();
        loginuser.setUsername("shengli");
        loginuser.setPassword("123456");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }


    @Test
    public void testLogin2(){
        UserDao dao = new UserDao();
        User user = dao.login("baomihua","123456");
        System.out.println(user);
    }
}