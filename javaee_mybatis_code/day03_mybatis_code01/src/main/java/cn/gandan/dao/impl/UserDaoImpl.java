package cn.gandan.dao.impl;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.QueryVo;
import cn.gandan.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
        this.sqlSession = factory.openSession();
    }

    public List<User> findAll() {

//        SqlSession sqlSession = factory.openSession();

        List<User> users = sqlSession.selectList("cn.gandan.dao.UserDao.findAll");

        sqlSession.close();

        return users;
    }

    public void saveUser(User user) {

//        SqlSession sqlSession = factory.openSession();

        sqlSession.insert("cn.gandan.dao.UserDao.saveUser",user);

        sqlSession.commit();

        sqlSession.close();

    }

    public void updateUser(User user) {

        sqlSession.update("cn.gandan.dao.UserDao.updateUser",user);

        sqlSession.commit();

        sqlSession.close();

    }

    public void deleteUser(int id) {

        sqlSession.delete("cn.gandan.dao.UserDao.deleteUser",id);

        sqlSession.commit();

        sqlSession.close();

    }

    public User findById(int id) {

        User user = sqlSession.selectOne("cn.gandan.dao.UserDao.findById",id);

        sqlSession.close();

        return user;

    }

    public List<User> findByUser(String username) {

        List<User> users = sqlSession.selectList("cn.gandan.dao.UserDao.findByUser","%"+username+"%");

        sqlSession.close();

        return users;

    }

    public int findTotal() {

        Integer count = sqlSession.selectOne("cn.gandan.dao.UserDao.findTotal");

        sqlSession.close();

        return count;

    }

    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    @Override
    public List<User> findUserByCondition(User user) {
        return null;
    }

    @Override
    public List<User> findUserByIds(QueryVo vo) {
        return null;
    }
}
