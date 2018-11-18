package cn.gandan.dao;

import cn.gandan.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    @Select("select * from account ")
    @Results(id = "accountMap", value = {
            @Result(id=true , column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid", one=@One(select="cn.gandan.dao.UserDao.findById", fetchType= FetchType.EAGER))
    })
    abstract List<Account> findAll();

    @Select("select * from account where uid = #{userId}")
    abstract List<Account> findAccountByUid(Integer userId);

}
