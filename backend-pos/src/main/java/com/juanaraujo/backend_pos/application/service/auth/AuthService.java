package com.juanaraujo.backend_pos.application.service.auth;

import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginRequest;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginResponseDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.RegisterRequestDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequest request);

    LoginResponseDTO register(RegisterRequestDTO request);

}
