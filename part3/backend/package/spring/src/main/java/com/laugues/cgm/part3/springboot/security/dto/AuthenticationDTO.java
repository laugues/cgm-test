package com.laugues.cgm.part3.springboot.security.dto;

/**
 * The type Authentication DTO.
 */
public class AuthenticationDTO
{
    private String token;

    /**
     * Instantiates a new AuthenticationDTO.
     *
     * @param token the token
     */
    public AuthenticationDTO(String token) {
        this.token = token;
    }

    /**
     * Get the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
}
