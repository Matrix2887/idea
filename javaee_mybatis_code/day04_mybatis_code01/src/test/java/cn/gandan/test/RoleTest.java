package cn.gandan.test;

import cn.gandan.dao.RoleDao;
import cn.gandan.dao.UserDao;
import cn.gandan.domain.Role;
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
import java.util.List;

public class RoleTest {

    private InputStream in = null;

    private SqlSessionFactory factory = null;

    private SqlSession sqlSession = null;

    private RoleDao mapper = null;

    private RoleDao userDao = null;

    @Before
    public void before() throws Exception{

        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);

        mapper = sqlSession.getMapper(RoleDao.class);


    }

    @After
    public void after() throws IOException {


        sqlSession.close();

        in.close();

    }

    @Test
    public void testFindAll() throws Exception{

        List<Role> all = mapper.findAll();

        for (Role role : all) {
            System.out.println("===================================================================");
            System.out.println(role);
            System.out.println("===================================================================");
        }

    }

}
