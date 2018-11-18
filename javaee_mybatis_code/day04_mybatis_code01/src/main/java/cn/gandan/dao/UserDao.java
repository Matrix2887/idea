package cn.gandan.dao;

import cn.gandan.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column = "address" , property = "address"),
            @Result(column = "sex" , property = "sex"),
            @Result(column = "birthday" , property = "birthday"),
            @Result(column="id",property="roles",
                    many=@Many(select="cn.gandan.dao.RoleDao.findRolesById",
                            fetchType= FetchType.LAZY))
    })
    abstract List<User> findAll();


    @Select("select * from user where id = #{uid}")
    abstract User findById(Integer uid);

    @Select("select * from user where id in (select uid from user_role where rid = #{rid} )")
    abstract List<User> findUsersById();



}
