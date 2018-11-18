package cn.gandan.test;

import cn.gandan.dao.UserDao;
import cn.gandan.dao.impl.UserDaoImpl;
import cn.gandan.domain.QueryVo;
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

public class Mybatis {

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

        userDao = new UserDaoImpl(factory);

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

        for (User user : users) {
            System.out.println("-------每个用户信息---------");
            System.out.println(user);
            System.out.println(user.getAccounts());
            System.out.println(user.getRoles());
        }

    }

    @Test
    public void testSaveUser(){

        User user = new User();
        user.setUsername("爆米花");
        user.setBirthday(new Date());
        user.setSex("仙");
        user.setAddress("天仙女");


        System.out.println("保存前" + user);
        userDao.saveUser(user);

        System.out.println("保存后" + user);

    }

//    @Test
//    public void testUpdateUser(){
//
//        User user = new User(50,"爆米花",new Date(),"仙","天上仙女");
//
//
//        userDao.updateUser(user);
//
//    }

    @Test
    public void testDeleteUser(){


        userDao.deleteUser(53);

    }

    @Test
    public void testFindById(){


        User u = userDao.findById(49);

        System.out.println(u);

    }

    @Test
    public void testFindByUser(){


        List<User> users = userDao.findByUser("王");

        for (User user : users) {

            System.out.println(user);

        }

    }

    @Test
    public void testFindTotal(){


        int total = userDao.findTotal();

        System.out.println(total);

    }

    @Test
    public void testFindUserByVo(){

        User user = new User();

        user.setUsername("%王%");

        QueryVo vo = new QueryVo();

        vo.setUser(user);

        List<User> users = mapper.findUserByVo(vo);

        for (User u : users) {

            System.out.println(u);

        }

    }

    @Test
    public void testFindUserByCondition(){

        User user = new User();
        user.setUsername("老王");
//        user.setSex("女");

        List<User> userByCondition = mapper.findUserByCondition(user);
        for (User u : userByCondition) {
            System.out.println(u);
        }

    }


    @Test
    public void testFindUserByIds(){
        QueryVo vo = new QueryVo();

        List<Integer> list = new ArrayList<>();

        list.add(50);
        list.add(46);
        list.add(49);
        list.add(51);
        vo.setIds(list);

        List<User> userByIds = mapper.findUserByIds(vo);
        for (User userById : userByIds) {
            System.out.println(userById);
        }
    }


}