package com.revature.daos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public User login(String ers_username, String ers_password, int user_role_fk){

        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from ers_users where ers_username = ? and ers_password = ? and user_role_fk = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ers_username);
            ps.setString(2, ers_password);
            ps.setInt(3, user_role_fk);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User(
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getInt("user_role_fk"),
                        null
                );

                int userRoleFk = rs.getInt("user_role_fk");
                RoleDAO rDAO = new RoleDAO();

                Role r = rDAO.getUserRoleById(userRoleFk);
                u.setRole(r);


                return u;

            }
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
            System.out.println("error here (AuthDAO)");
        }

        return null;
    }
}
