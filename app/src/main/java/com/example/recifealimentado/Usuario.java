package com.example.recifealimentado;

public class Usuario {
    private String name;
    private String email;
    private String collaboration;


    public Usuario(String name, String email, String collaboration) {
        this.name = name;
        this.email = email;
        this.collaboration = collaboration;

    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCollaboration() {
        return collaboration;
    }



}
