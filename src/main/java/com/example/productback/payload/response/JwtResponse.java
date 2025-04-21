package com.example.productback.payload.response;

import lombok.Data;

@Data

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String firstname;
    private String email;

    public JwtResponse(String accessToken, Long id, String username, String firstname, String email) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.email = email;
    }
}
