package com.neo.model;

import java.util.Calendar;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class User {

    @NotEmpty(message = "User name is required.")
    @Size(min = 4, max = 100, message = "Password should be longer than 4 characters and shorter than 100 characters")
    private String userName;

    @NotEmpty(message = "Password is required.")
    @Size(min = 8, max = 100, message = "Password should be longer than 8 characters and shorter than 100 characters")
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}