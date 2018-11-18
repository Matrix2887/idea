package cn.gandan.day04.util;

import javax.xml.transform.Result;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class UtilsJDBC {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            Properties prop = new Properties();
            ClassLoader classLoader = UtilsJDBC.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
            String path = res.getPath();
//            prop.load(new FileReader("D:\\A\\javawe-mysql-code\\day04-jdbc\\src\\jdbc.properties"));
//            prop.load(new FileReader(path));
            prop.load(resourceAsStream);
            System.out.println(path);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");
                Class.forName(driver);
            } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement stat,Connection conn){
        if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stat, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
