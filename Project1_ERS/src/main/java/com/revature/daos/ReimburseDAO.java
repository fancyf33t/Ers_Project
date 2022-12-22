package com.revature.daos;

import com.revature.models.Reimburse;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ReimburseDAO implements ReimburseDAOInterface {
    @Override
    public ArrayList<Reimburse> getReimbursement() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ers_reimbursement;";
            //statement
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<Reimburse> reimburseList = new ArrayList<>();

            //rs.next() while loop
            while (rs.next()){
                Reimburse r = new Reimburse(
//                        rs.getInt("reimbursement_id"),
                        rs.getInt("reimbursement_amount"),
                        rs.getString("reimbursement_desc"),
                        rs.getInt("reimbursement_type_fk"),
                        rs.getInt("reimbursement_status_fk"),
                        rs.getInt("reimbursement_user_fk")
                );
                // try Role?
//                int roleFK = rs.getInt("user_role_id");
//                RoleDAO rDAO = new RoleDAO();

                reimburseList.add(r);
            }
            return reimburseList;
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Reimburse insertReimbursement(Reimburse rb) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into ers_reimbursement " +
                    "(reimbursement_amount, reimbursement_desc, reimbursement_type_fk, " +
                    "reimbursement_status_fk, reimbursement_user_fk) values(?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rb.getReimbursement_amount());
            ps.setString(2, rb.getReimbursement_desc());
            ps.setInt(3, rb.getReimbursement_type_fk());
            ps.setInt(4, rb.getReimbursement_status_fk());
            ps.setInt(5, rb.getReimbursement_user_fk());

            //execute
            ps.executeUpdate();

            return rb;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reimburse updateReimbursement(Reimburse rb) {
        return null;
    }
}
