package com.juanaraujo.backend_pos.infraestructure.controller.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.juanaraujo.backend_pos.application.service.auth.AuthService;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginRequest;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginResponseDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.RegisterRequestDTO;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

     @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public LoginResponseDTO register(@RequestBody RegisterRequestDTO request) {
        return authService.register(request);
    }
}