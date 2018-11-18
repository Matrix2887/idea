package cn.gandan.test;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;


import cn.gandan.mybatis.io.Resources;
import cn.gandan.mybatis.sqlsession.SqlSession;
import cn.gandan.mybatis.sqlsession.SqlSessionFactory;
import cn.gandan.mybatis.sqlsession.SqlSessionFactoryBuilder;


//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {

        // 解析XML获取数据库链接信息,以及映射文件的位置
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 创建建造者,建造者会根据信息创建工厂类对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 创建者,根据主配置文件的字节流 ,创建工厂类对象
        // 多态, 返回的是工厂接口的实现类new DefaultSqlSessionFactory(cfg)
        SqlSessionFactory build = builder.build(in);

        // 工厂类对象创建使用sql的SqlSession对象
        // 在实现类中,运行时调用实现类中的方法,这也是多态,返回的是实现类
        SqlSession sqlSession = build.openSession();

        // SqlSession利用代理模式增强了接口,代理出实现类
        // 在实现类中创建数据库的连接, Proxy.newProxyInstance这方法代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 调用方法
        List<User> user = userDao.findAll();

        // 关闭资源
        sqlSession.close();

        in.close();

        System.out.println(user);

    }

}
