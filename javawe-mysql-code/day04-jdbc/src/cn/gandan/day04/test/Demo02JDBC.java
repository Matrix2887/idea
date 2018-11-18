package cn.gandan.day04.test;

import java.sql.*;

public class Demo02JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet re = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bd", "root", "root");
            stat = conn.createStatement();
            re = stat.executeQuery("SELECT * FROM SEEDED");
            while(re.next()){
                int anInt = re.getInt("id");
                String name = re.getString("name");
                String orz = re.getString("orz");
                System.out.println(anInt + name + orz);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(re != null){
                try {
                    re.close();
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
}
