package com.diaspark.INB.DTO;

import javax.validation.constraints.NotEmpty;

public class LoginUserDTO {

    @NotEmpty(message="Please provide your username")
    private String username;

    @NotEmpty(message="Please provide your password")
    private String password;

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

