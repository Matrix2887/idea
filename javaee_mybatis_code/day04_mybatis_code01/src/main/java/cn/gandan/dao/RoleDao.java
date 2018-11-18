package cn.gandan.dao;

import cn.gandan.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {


    @Select("select * from role")
    @Results( value = {
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "role_name", property = "roleName"),
            @Result(column = "role_desc", property = "roleDesc"),
            @Result(property = "users", column = "id", many = @Many(select = "cn.gandan.dao.UserDao.findUsersById", fetchType = FetchType.LAZY))
    })
    abstract List<Role> findAll();


    @Select("select * from role where id = #{rid}")
    public Role findById(Integer rid);

    @Select("select * from role where id in (select rid from user_role where uid = #{uid})")
    abstract List<Role> findRolesById();


}
