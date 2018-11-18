package cn.gandan.day04.demo01;

import java.sql.*;

public class Demo07JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bd", "root", "root");
            String sql = "select * from seeded";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String orz = rs.getString("orz");
            System.out.println(id +"--"+ name +"--"+ orz);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
}
