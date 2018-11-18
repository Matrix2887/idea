package cn.gandan.day04.demo01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01JDBC {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql:///bd", "root", "root");
        String sql = "update seeded set id = 333";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        conn.close();
    }

}
