package cn.gandan.dao;

import cn.gandan.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    @Select("SELECT * FROM account")
    abstract List<Account> findAll();

    @Update("INSERT INTO account (name, money) VALUE (#{name}, #{money})")
    abstract void save(Account account);

}
