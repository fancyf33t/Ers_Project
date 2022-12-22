package com.revature.daos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public User login(String username, String password){

        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from ers_users where username = ? and password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User(
                        rs.getInt("ers_user_id"),
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getInt("user_role_fk")
                );

                int userRoleFk = rs.getInt("user_role_id_fk");

                RoleDAO rDAO = new RoleDAO();

                Role r = rDAO.getUserRoleById(userRoleFk);

                return u;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
