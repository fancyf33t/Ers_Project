package com.revature.daos;


import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface{
    @Override
    public Role getUserRoleById(int id){
        //use a try-with-resources block to open connection and host our DB communication
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from user_roles where user_role_id = ?;"; //does this match?

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            /*
            While loop to extract the resultSet data
             */
            while(rs.next()){
                Role userRole = new Role(
                        rs.getInt("user_role_id"),
                        rs.getString("user_role")
                );
                return userRole;
            }
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return null;
    }
}
