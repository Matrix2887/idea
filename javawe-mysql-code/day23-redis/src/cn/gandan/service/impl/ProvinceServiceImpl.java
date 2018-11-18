package cn.gandan.service.impl;

import cn.gandan.dao.ProvinceDao;
import cn.gandan.dao.impl.ProvinceDaoImpl;
import cn.gandan.domain.Province;
import cn.gandan.jedis.util.JedisPoolUtils;
import cn.gandan.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJedis() {

        System.out.println("执行查询方法");
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_jedis = jedis.get("province");

        if(province_jedis == null || province_jedis.length() == 0){
            System.out.println("内存没有,加载数据库");
            List<Province> all = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_jedis = mapper.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_jedis);
            jedis.close();
        }else {
            System.out.println("内存有数据,加载缓存");
        }

        return province_jedis;
    }
}
