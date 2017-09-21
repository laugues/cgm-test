package com.laugues.cgm.dto.user;

/**
 * The UserDTO DTO
 */
public class UserDTO
{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
