package cn.gandan.test;

import cn.gandan.dao.AccountDao;
import cn.gandan.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {


    @Test
    public void test() throws IOException {

        Account account = new Account();
        account.setName("盛利利");
        account.setMoney(1314.0);

        InputStream in = Resources.getResourceAsStream("SqlMapConfig");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = build.openSession(true);

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        accountDao.save(account);

        sqlSession.close();

        in.close();



    }

}
