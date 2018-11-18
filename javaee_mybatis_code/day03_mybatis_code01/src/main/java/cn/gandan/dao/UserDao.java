package cn.gandan.dao;

import cn.gandan.domain.QueryVo;
import cn.gandan.domain.User;

import java.util.List;

public interface UserDao {

    abstract List<User> findAll();

    abstract void saveUser(User user);

    abstract void updateUser(User user);

    abstract void deleteUser(int id);

    abstract User findById(int id);

    abstract List<User> findByUser(String username);

    abstract int findTotal();

    abstract List<User> findUserByVo(QueryVo vo);

    abstract List<User> findUserByCondition(User user);

    abstract List<User> findUserByIds(QueryVo vo);

}
