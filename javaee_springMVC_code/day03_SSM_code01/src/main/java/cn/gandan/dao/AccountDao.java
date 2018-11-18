package cn.gandan.dao;

import cn.gandan.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public interface AccountDao {

    // 查询所有
    @Select("SELECT * FROM account")
    abstract List<Account> findAll();

    // 根据id查询
    @Select("SELECT * FROM account WHERE id = #{id}")
    abstract Account findById();

    // 保存用户
    @Update("INSERT INTO account (name, money) VALUE (#{name}, #{money})")
    abstract void save(Account account);

}
