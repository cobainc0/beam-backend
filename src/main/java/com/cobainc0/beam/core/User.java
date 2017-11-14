package com.cobainc0.beam.core;


import java.security.Principal;

public class User implements Principal {

    private String role;
    private String name;
    private String password;

    public User(){
        //default name for user - test
        this.name = "cherry v";
        this.password = "pa55word";
        this.role = "admin";
    }
    public User(String username){
        this.name = username;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getName() {
        return name;
    }

     public String getPassword() {
        return password;
    }
}
