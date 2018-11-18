package cn.gandan.day04.test;

import cn.gandan.day04.demo01.Demo08JDBC;
import cn.gandan.day04.demo01.Seeded;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GetBack {
    public static void main(String[] args) {
        List<Seeded> seededs = new Demo08JDBC().showFind();

        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.11.99:3306/db1", "root", "root");
            stat = conn.createStatement();
//            stat.executeUpdate("CREATE TABLE seedbe(id INT ,name VARCHAR(20),orz VARCHAR(20),bithday VARCHAR(20))");
            for (Seeded seeded : seededs) {
                int i = stat.executeUpdate("INSERT INTO seedbe VALUE ('"+seeded.getId()+"','"+seeded.getName()+"','"+seeded.getOrz()+"','"+seeded.getDate()+"')");
                System.out.println(i);
            }
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
