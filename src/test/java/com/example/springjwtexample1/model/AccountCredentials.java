package com.example.springjwtexample1.model;

public class AccountCredentials {
    public String username;
    public String password;

    public AccountCredentials() {};

    public AccountCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}