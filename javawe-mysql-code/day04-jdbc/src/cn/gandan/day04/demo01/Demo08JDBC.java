package cn.gandan.day04.demo01;

import cn.gandan.day04.util.UtilsJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo08JDBC {
    public static void main(String[] args) {
        List<Seeded> seed = findAll();
        for (Seeded seeded : seed) {
            System.out.println(seeded);
        }
        System.out.println(seed.size());
    }

    public static List<Seeded> findAll(){
        List<Seeded> seededs = new ArrayList<>();
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
                String name = rs.getString("name");
                String orz = rs.getString("orz");
                Date birthday = rs.getDate("birthday");
                seededs.add(new Seeded(id,name,orz,birthday));
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
        return seededs;
    }

    public List<Seeded> showFind(){
        List<Seeded> seededs = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///bd", "root", "root");
             conn = UtilsJDBC.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from seeded");

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String orz = rs.getString("orz");
                Date birthday = rs.getDate("birthday");
                seededs.add(new Seeded(id,name,orz,birthday));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           UtilsJDBC.close(rs,stat,conn);
        }
        return seededs;
    }
}
