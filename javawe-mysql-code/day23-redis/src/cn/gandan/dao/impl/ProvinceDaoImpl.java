package cn.gandan.dao.impl;

import cn.gandan.dao.ProvinceDao;
import cn.gandan.domain.Province;
import cn.gandan.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {

        String sql = "SELECT * FROM province";

        List<Province> query = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return query;
    }
}
