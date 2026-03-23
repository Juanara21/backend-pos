package com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Data
public class LoginRequest {
    private String username;
    private String password;
}