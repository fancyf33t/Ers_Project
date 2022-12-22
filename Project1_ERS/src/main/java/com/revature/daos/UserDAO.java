package com.revature.daos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

//import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements UserDAOInterface{
    @Override
    public ArrayList<User> getUsers(){
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ers_users;";
            //statement
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<User> userList = new ArrayList<>();

            //rs.next() while loop
            while (rs.next()) {
                User u = new User(
                        rs.getInt("ers_user_id"),
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getInt("user_role_fk")
                );
                // retrieve user id
//                int user_Fk = rs.getInt("user_role_fk"); // retrieve id?

//                //RoleDao???
//                RoleDAO rDAO = new RoleDAO();
//                Role r = rDAO.getRoleById(user_Fk);
//                u.setRole(r);
                userList.add(u);

            }
            return userList;
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User insertUser(User us) {
        return null;
    }

    @Override
    public User deletUser(User us) {
        return null;
    }
}
