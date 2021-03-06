package cn.gandan.day04.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bd", "root", "root");
            String sql = "update seeded set id = 222 where name = '格拉汉姆.艾卡'";
            stat = conn.createStatement();
            int i = stat.executeUpdate(sql);
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
}
