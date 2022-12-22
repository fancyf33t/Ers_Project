package com.revature.models;

public class Reimburse {
    //copy table from DBeaver
    private int reimbursement_id;
    private int reimbursement_amount;
    private String reimbursement_desc;
    private int reimbursement_type_fk;
    private int reimbursement_status_fk;
    private int reimbursement_user_fk;

    //empty constructor

    public Reimburse() {
    }

    //all-args constructor

    public Reimburse(int reimbursement_id, int reimbursement_amount, String reimbursement_desc, int reimbursement_type_fk, int reimbursement_status_fk, int reimbursement_user_fk) {
        this.reimbursement_id = reimbursement_id;
        this.reimbursement_amount = reimbursement_amount;
        this.reimbursement_desc = reimbursement_desc;
        this.reimbursement_type_fk = reimbursement_type_fk;
        this.reimbursement_status_fk = reimbursement_status_fk;
        this.reimbursement_user_fk = reimbursement_user_fk;
    }

    //all-args constructor minus id

    public Reimburse(int reimbursement_amount, String reimbursement_desc, int reimbursement_type_fk, int reimbursement_status_fk, int reimbursement_user_fk) {
        this.reimbursement_amount = reimbursement_amount;
        this.reimbursement_desc = reimbursement_desc;
        this.reimbursement_type_fk = reimbursement_type_fk;
        this.reimbursement_status_fk = reimbursement_status_fk;
        this.reimbursement_user_fk = reimbursement_user_fk;
    }

    //getter/setter

    public int getReimbursement_id() {
        return reimbursement_id;
    }

    public void setReimbursement_id(int reimbursement_id) {
        this.reimbursement_id = reimbursement_id;
    }

    public int getReimbursement_amount() {
        return reimbursement_amount;
    }

    public void setReimbursement_amount(int reimbursement_amount) {
        this.reimbursement_amount = reimbursement_amount;
    }

    public String getReimbursement_desc() {
        return reimbursement_desc;
    }

    public void setReimbursement_desc(String reimbursement_desc) {
        this.reimbursement_desc = reimbursement_desc;
    }

    public int getReimbursement_type_fk() {
        return reimbursement_type_fk;
    }

    public void setReimbursement_type_fk(int reimbursement_type_fk) {
        this.reimbursement_type_fk = reimbursement_type_fk;
    }

    public int getReimbursement_status_fk() {
        return reimbursement_status_fk;
    }

    public void setReimbursement_status_fk(int reimbursement_status_fk) {
        this.reimbursement_status_fk = reimbursement_status_fk;
    }

    public int getReimbursement_user_fk() {
        return reimbursement_user_fk;
    }

    public void setReimbursement_user_fk(int reimbursement_user_fk) {
        this.reimbursement_user_fk = reimbursement_user_fk;
    }

    @Override
    public String toString(){
        return "Reimbursement{"+
                "reimbursement_id=" + reimbursement_id +
                ", reimbursement_amount'" + reimbursement_amount + '\'' +
                ", reimbursement_desc'" + reimbursement_desc + '\'' +
                ", reimbursement_type'" + reimbursement_type_fk + '\'' +
                ", reimbursement_status'" + reimbursement_status_fk + '\'' +
                ", reimbursement_user'" + reimbursement_user_fk +
                '}';
    }
}
