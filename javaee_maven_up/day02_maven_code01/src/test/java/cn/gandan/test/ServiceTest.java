package cn.gandan.test;

import cn.gandan.domain.User;
import cn.gandan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {

    @Test
    public void findAll(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = ac.getBean(UserService.class);

        List<User> users = userService.findAll();

        for (User user : users) {
            System.out.println(user);
        }


    }

}
