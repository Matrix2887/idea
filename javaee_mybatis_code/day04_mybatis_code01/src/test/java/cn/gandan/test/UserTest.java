package cn.gandan.test;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {

    private InputStream in = null;

    private SqlSessionFactory factory = null;

    private SqlSession sqlSession = null;

    private UserDao mapper = null;

    private UserDao userDao = null;

    @Before
    public void before() throws Exception{

        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);

        mapper = sqlSession.getMapper(UserDao.class);


    }

    @After
    public void after() throws IOException {

//        sqlSession.commit();

        sqlSession.close();

        in.close();

    }

    @Test
    public void testFindAll() throws Exception{

//        List<User> users = mapper.findAll();



        List<User> users = mapper.findAll();

//        for (User user : users) {
//            System.out.println("-------每个用户信息---------");
//            System.out.println(user);
//            System.out.println(user.getAccounts());
//        }

    }


    @Test
    public void testFindById(){

        User u = mapper.findById(52);
        System.out.println(u);

    }



}
