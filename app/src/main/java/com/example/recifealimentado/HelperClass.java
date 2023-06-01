package com.example.recifealimentado;

public class HelperClass {

    private String name;
    private String email;
    private String username;
    private String password;
    private String collaboration;

    public HelperClass() {

    }

    public HelperClass(String name, String email, String username, String password, String collaboration) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.collaboration = collaboration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(String collaboration) {
        this.collaboration = collaboration;
    }
}