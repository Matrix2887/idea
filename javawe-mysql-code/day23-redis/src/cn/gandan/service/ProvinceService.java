package cn.gandan.service;

import cn.gandan.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJedis();

}
