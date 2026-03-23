package com.juanaraujo.backend_pos.application.service.auth;

import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(String username, String password);

}
