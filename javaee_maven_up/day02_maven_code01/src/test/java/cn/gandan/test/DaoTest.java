package cn.gandan.test;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DaoTest {


    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = ac.getBean(UserDao.class);

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }

    }


}
