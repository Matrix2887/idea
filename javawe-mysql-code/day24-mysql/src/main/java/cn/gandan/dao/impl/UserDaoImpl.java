package cn.gandan.dao.impl;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public List<User> findAll() throws Exception {

        List<User> users = new ArrayList<User>();

        Connection connection = null;

        PreparedStatement pst = null;

        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql:///day17","root","root");

            pst = connection.prepareCall("SELECT * FROM user");

            rs = pst.executeQuery();

            while (rs.next()){
                User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("gender"),
                        rs.getInt("age"),rs.getString("address"),rs.getString("qq"),rs.getString("email"));
                        users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            rs.close();

            pst.close();

            connection.close();
        }

        return users;
    }
}
