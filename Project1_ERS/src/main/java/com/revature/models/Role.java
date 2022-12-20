package com.revature.models;

/*DBeaver database
Make sure this all matches
 */
public class Role {
    //match the variable names
    private int user_role_id;
    private String user_role;

    //generate constructor

    public Role() {
    }

    //generate all-args
    public Role(int user_role_id, String user_role) {
        this.user_role_id = user_role_id;
        this.user_role = user_role;
    }

    //generate all-args w/out id constructor
    public Role(String user_role) {
        this.user_role = user_role;
    }

    /*
    generate getters/setters
    shortcut: alt+ins
     */

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    //toString method

    @Override
    public String toString() {
        return "Role{" +
                "user_role_id=" + user_role_id +
                ", user_role='" + user_role + '\'' +
                '}';
    }
}
