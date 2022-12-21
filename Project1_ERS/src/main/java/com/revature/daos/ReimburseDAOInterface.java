package com.revature.daos;

public interface ReimburseDAOInterface {
    // lay out functionalities
    ArrayList<Reimburse> getReimbursements();

    Reimburse insertReimbursements(Reimburse rb);
    Reimburse deleteReimbursement(Reimburse rb);
}
