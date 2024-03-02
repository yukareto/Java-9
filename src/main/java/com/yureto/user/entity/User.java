package com.yureto.user.entity;

public class User {
    public Integer id;
    public String name;
    public String email;

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static User createUser(String name, String email) {
        return new User(null, name, email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
