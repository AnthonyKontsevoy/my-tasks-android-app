package com.anthonyestacado.mytasks.model;

/**
 * Created by Anthony Kontsevoy on 07.03.2018.
 */

public class User {

    private int userID;
    private String username;
    private String password;

    //Change this constructor when you start implementing multi-user support.
    public User() {
        userID = 1;
        username = "default user";
        password = "password";
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}
