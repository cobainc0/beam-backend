package com.cobainc0.beam.core;


import java.security.Principal;

public class User implements Principal {

    private String role;
    private String name;
    private String password;

    public User(){
        this.name = "cherry v";
        this.password = "pa55word";
        this.role = "admin";
    }
    public User(String username){
        this.name = username;
    }

    public User(String username, String password){ this.name = username; this.password = password; }

    public String getRole() {
        return role;
    }

    @Override
    public String getName() { return name; }

    public String getPassword() {
        return password;
    }
}
