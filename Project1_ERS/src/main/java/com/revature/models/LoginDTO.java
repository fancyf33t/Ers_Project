package com.revature.models;

public class LoginDTO {

    private String ers_username;
    private String ers_password;
    private int user_role_fk;

    public LoginDTO() {
    }

    public LoginDTO(String ers_username, String ers_password, int user_role_fk) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_role_fk = user_role_fk;
    }

    //getter/setter

    public String getErs_username() {
        return ers_username;
    }

    public void setErs_username(String ers_username) {
        this.ers_username = ers_username;
    }

    public String getErs_password() {
        return ers_password;
    }

    public void setErs_password(String ers_password) {
        this.ers_password = ers_password;
    }

    public int getUser_role_fk() {
        return user_role_fk;
    }

    public void setUser_role_fk(int user_role_fk) {
        this.user_role_fk = user_role_fk;
    }
}
