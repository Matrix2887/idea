package cn.gandan.day04.demo01;

import cn.gandan.day04.util.UtilsJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo09JDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名");
        String username = sc.nextLine();
        System.out.println("密码");
        String password = sc.nextLine();
        boolean flag = new Demo09JDBC().login(username,password);
        if(flag){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }


    public boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = UtilsJDBC.getConnection();
            String sql = "SELECT * FROM USER WHERE username ='"+username+"'AND PASSWORD ='"+password+"'";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilsJDBC.close(rs,stat,conn);
        }
        return false;
    }

}
