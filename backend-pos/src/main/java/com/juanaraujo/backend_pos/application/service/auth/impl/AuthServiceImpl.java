package com.juanaraujo.backend_pos.application.service.auth.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.juanaraujo.backend_pos.application.service.auth.AuthService;
import com.juanaraujo.backend_pos.domain.model.user.User;
import com.juanaraujo.backend_pos.domain.repository.user.UserRepository;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginResponseDTO;
import com.juanaraujo.backend_pos.infraestructure.security.JwtService;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponseDTO login(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(user.getUsername(), user.getRole());

        // 🔥 Aquí usas el token como fuente
        String usernameFromToken = jwtService.extractUsername(token);
        String roleFromToken = jwtService.extractRole(token);

        return LoginResponseDTO.builder()
                .username(usernameFromToken)
                .token(token)
                .role(roleFromToken)
                .build();
    }


}