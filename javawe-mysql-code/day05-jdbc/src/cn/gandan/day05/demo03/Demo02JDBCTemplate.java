package cn.gandan.day05.demo03;

import cn.gandan.day05.utils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo02JDBCTemplate {
//    public static void main(String[] args) {
//        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//        int update = template.update("UPDATE seeded SET id = 332 WHERE name = '基拉'");
//        int i = template.update("INSERT INTO seeded VALUE (2887,'正义高达',2,'高达','无',null)");
//        int update = template.update("DELETE FROM seeded WHERE id = 2887");
//        System.out.println(update);
//    }
    private static JdbcTemplate template = null;

    @Before
    public void start(){
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }


    @Test
    public void test1(){
        int update = template.update("UPDATE seeded SET id = 233 WHERE name = '基拉'");
        System.out.println(update);
    }
    @Test
    public void gu(){
        int update = template.update("INSERT INTO seedbe VALUE (?,?,?,?)", "8766", "巴基露露", "主天使", "2018-06-20");
        System.out.println(update);
    }

    @Test
    public void gu2(){
        int update = template.update("UPDATE seedbe SET id = ? WHERE name = ?", 87, "巴基露露");
        System.out.println(update);
    }


    @Test
    public void gu3(){
        int update = template.update("DELETE FROM seedbe WHERE id = ?", 87);
        System.out.println(update);
    }


    @Test
    public void test2(){
        int update = template.update("INSERT INTO seeded VALUE (2887,'正义高达',2,'高达','无',null)");
        System.out.println(update);
    }

    @Test
    public void test3(){
        int update = template.update("DELETE FROM seeded WHERE id = ? ",2887);
        System.out.println(update);
    }

    @Test
    public void test4(){
        Map<String, Object> map = template.queryForMap("SELECT * FROM seeded WHERE id = ?", 233);
        System.out.println(map);
    }


    @Test
    public void gu4(){
        Map<String, Object> map = template.queryForMap("SELECT * FROM seedbe WHERE id = ?", 222);
        System.out.println(map);
    }

    @Test
    public void test5(){
        List<Map<String, Object>> list = template.queryForList("SELECT * FROM seeded");
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    @Test
    public void gu6(){
        List<Map<String, Object>> maps = template.queryForList("SELECT * FROM seedbe WHERE id = ?", 333);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void gu8(){
        List<Seeded> query = template.query("SELECT * FROM seedbe", new BeanPropertyRowMapper<Seeded>());
        for (Seeded seeded : query) {
            System.out.println(seeded);
        }
    }

    @Test
    public void test6(){
        List<Seeded> list = template.query("SELECT * FROM seeded", new RowMapper<Seeded>() {
            @Override
            public Seeded mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String orz = rs.getString("orz");
                String seed = rs.getString("seed");
                Date birthday = rs.getDate("birthday");
                Seeded seeded = new Seeded(id,name,age,orz,seed,birthday);
                return seeded;
            }
        });

        for (Seeded seeded : list) {
            System.out.println(seeded);
        }
    }

    @Test
    public void test7(){
        List<Seeded> list = template.query("SELECT * FROM seeded",new BeanPropertyRowMapper<Seeded>(Seeded.class));
        for (Seeded seeded : list) {
            System.out.println(seeded);
        }
    }

    @Test
    public void test8(){
        Integer i = template.queryForObject("SELECT COUNT(id) FROM seeded",Integer.class);
        System.out.println(i);
    }
}
