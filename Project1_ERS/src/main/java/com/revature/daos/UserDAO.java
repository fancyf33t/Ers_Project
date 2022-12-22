package com.revature.daos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
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
                //replace ers_user_id with ers_username; add role
                User u = new User(
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getInt("user_role_fk"),
                        null
                );
                // retrieve user id
                int user_Fk = rs.getInt("user_role_fk"); // retrieve id?

                //RoleDao???
                RoleDAO rDAO = new RoleDAO();
                Role r = rDAO.getUserRoleById(user_Fk);
                u.setRole(r);
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
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into ers_users (ers_username, ers_password, user_role_fk) values(?,?,?);";
            //instantiate a prepared statement to hold our SQL and fill its variables
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, us.getErs_username());
            ps.setString(2, us.getErs_password());
            ps.setInt(3, us.getUser_role_fk());

            //execute
            ps.executeUpdate();

            return us;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User deletUser(User us) {
        return null;
    }
}
