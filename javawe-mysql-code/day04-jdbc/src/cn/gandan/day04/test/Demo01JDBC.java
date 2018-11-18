package cn.gandan.day04.test;

import java.sql.*;

public class Demo01JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bd", "root", "root");
            stat = conn.createStatement();
            int i = stat.executeUpdate("INSERT INTO seeded VALUE (69,'提子',23,'变革者','无',null)");
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
