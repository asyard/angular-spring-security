package com.asy.test.angular.model;

/**
 * Created by Asil on 10.10.2016.
 */
public class User {

    private String name;
    private String surname;

    public User(String n, String s) {
        name = n;
        surname = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
