package cn.gandan.day05.demo01;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo01C3p0 {
    public static void main(String[] args) throws SQLException {
        // D:\A\javawe-mysql-code\day05-jdbc\libs\c3p0-0.9.5.2.jar!\com\mchange\v2\c3p0\ComboPooledDataSolassurce.c
//        DataSource ds = new ComboPooledDataSource();
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
