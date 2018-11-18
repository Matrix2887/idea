package cn.gandan.day05.demo02;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Demo01Druid {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream is = Demo01Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
