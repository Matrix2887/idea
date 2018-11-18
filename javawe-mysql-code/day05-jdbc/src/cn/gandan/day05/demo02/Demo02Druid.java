package cn.gandan.day05.demo02;

import cn.gandan.day05.utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Demo02Druid {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO seeded value(8766,'巴基露露',30,'军人家庭','无',null)";
            pstat = conn.prepareStatement(sql);
            int i = pstat.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstat,conn);
        }
    }
}
