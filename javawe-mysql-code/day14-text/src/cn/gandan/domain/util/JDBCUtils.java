package cn.gandan.domain.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    // 德鲁伊的工具类,用于获取数据库的连接池
    private static DataSource ds;

    static {
        try {
            // 获取配置文件
            Properties prop = new Properties();
            // 获取配置文件的字节输入流
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            // 加载配置文件进内存
            prop.load(resourceAsStream);
            // 获取数据库连接池,根据数据库连接池工厂
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }




}
