package cn.gandan.dao;

import cn.gandan.domain.Role;

import java.util.List;

public interface RoleDao {

    abstract List<Role> findAll();
}
