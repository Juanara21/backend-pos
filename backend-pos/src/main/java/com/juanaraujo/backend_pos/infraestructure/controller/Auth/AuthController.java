package com.juanaraujo.backend_pos.infraestructure.controller.Auth;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juanaraujo.backend_pos.application.service.auth.AuthService;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginRequest;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginResponseDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.RegisterRequestDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.apiResponse.ApiResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@RequestBody LoginRequest request) {

        LoginResponseDTO response = authService.login(request);

        return ResponseEntity.ok(
                new ApiResponse<>(response, "Login exitoso", null));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> register(
            @RequestBody RegisterRequestDTO request) {

        LoginResponseDTO result = authService.register(request);

        return ResponseEntity.ok(
                new ApiResponse<>(result, "Registro exitoso", null));
    }
}