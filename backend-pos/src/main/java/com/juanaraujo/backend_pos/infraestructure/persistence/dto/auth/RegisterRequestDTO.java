package com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
}