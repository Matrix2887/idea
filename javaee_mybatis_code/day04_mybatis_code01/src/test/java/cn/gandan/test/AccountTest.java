package cn.gandan.test;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
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

public class AccountTest {

    private InputStream in = null;

    private SqlSessionFactory factory = null;

    private SqlSession sqlSession = null;

    private AccountDao mapper = null;


    @Before
    public void before() throws Exception{

        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);

        mapper = sqlSession.getMapper(AccountDao.class);

    }

    @After
    public void after() throws IOException {

//        sqlSession.commit();

        sqlSession.close();

        in.close();

    }

    @Test
    public void testFindAll(){

        List<Account> accounts = mapper.findAll();

        for (Account account : accounts) {
            System.out.println("-----------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }




}
