package com.revature.daos;

import com.revature.models.Reimburse;

import java.util.ArrayList;

public interface ReimburseDAOInterface {
    // lay out functionalities
    ArrayList<Reimburse> getReimbursement();

    //remove Reimburse rb
    Reimburse insertReimbursement(Reimburse rb);

    Reimburse updateReimbursement(Reimburse rb);
}
