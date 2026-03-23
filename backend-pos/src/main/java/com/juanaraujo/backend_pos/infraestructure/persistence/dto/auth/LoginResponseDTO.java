package com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private String username;
    private String token;
    private String role;

}
