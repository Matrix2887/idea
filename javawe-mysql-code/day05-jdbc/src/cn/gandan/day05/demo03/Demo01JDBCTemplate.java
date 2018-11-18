package cn.gandan.day05.demo03;

import cn.gandan.day05.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo01JDBCTemplate {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        int update = template.update("UPDATE seeded SET id = 332 WHERE name = '基拉'");
        System.out.println(update);

//        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//        template.update("")
    }
}
