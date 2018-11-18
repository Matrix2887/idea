package cn.gandan.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplate_02 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean");

        JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        template.execute("INSERT INTO account (name, money) VALUE ('爆米花花', 5201314)");


        /*JdbcTemplate template = new JdbcTemplate();

        DriverManagerDataSource dmd = new DriverManagerDataSource();

        dmd.setDriverClassName("com.mysql.jdbc.Driver");

        dmd.setUrl("jdbc:mysql://localhost:3306/eesy");

        dmd.setUsername("root");

        dmd.setPassword("root");

        template.setDataSource(dmd);

        template.execute("INSERT INTO account (name, money) VALUE ('盛利利', 5201314)");*/

    }

}
