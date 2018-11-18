package cn.gandan.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplate_01 {

    public static void main(String[] args) {


        JdbcTemplate template = new JdbcTemplate();

        DriverManagerDataSource dmd = new DriverManagerDataSource();

        dmd.setDriverClassName("com.mysql.jdbc.Driver");

        dmd.setUrl("jdbc:mysql://localhost:3306/eesy");

        dmd.setUsername("root");

        dmd.setPassword("root");

        template.setDataSource(dmd);

        template.execute("INSERT INTO account (name, money) VALUE ('盛利利', 5201314)");

    }

}
