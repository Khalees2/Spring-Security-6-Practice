package com.practice.springsecurity.model;

import java.util.ArrayList;

public class User {
    private String userId;
    private String password;
    private ArrayList<String> roles;

    public User(String userId, String password, ArrayList<String> rolesSet) {
        this.userId = userId;
        this.password = password;
        this.roles = rolesSet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", rolesSet=" + roles +
                '}';
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }


}
