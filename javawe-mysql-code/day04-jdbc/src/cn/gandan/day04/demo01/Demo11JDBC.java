package cn.gandan.day04.demo01;

import cn.gandan.day04.util.UtilsJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo11JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = UtilsJDBC.getConnection();

            conn.setAutoCommit(false);

            String sql1 = "update user set password = password - ? where id = ?";
            String sql2 = "update user set password = password + ? where id = ?";
            pstmt1= conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setInt(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setInt(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            UtilsJDBC.close(pstmt1,null);
            UtilsJDBC.close(pstmt2,conn);
        }
    }

}
