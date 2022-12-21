package com.revature.models;

public class User {
    // match the variables of ers_users
    private String ers_username;
    private String ers_password;
    private String first_name;
    private String last_name;
//    make sure you have a role
//    stick with int 0-1 for employee/manager roles
//    make an entire role object

    //no args constructor
    public User() {
    }
    //all args constructor
    public User(String ers_username, String ers_password, String first_name, String last_name) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    //all arg w/out id constructor

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    //toString

    @Override
    public String toString() {
        return "User{" +
                "ers_username='" + ers_username + '\'' +
                ", ers_password='" + ers_password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
