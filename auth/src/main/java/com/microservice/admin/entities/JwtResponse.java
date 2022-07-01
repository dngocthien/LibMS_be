package com.microservice.admin.entities;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private Integer id;
    private String email;

    public JwtResponse(String jwt, Integer id, String email) {
    }
}
