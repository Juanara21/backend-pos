package com.juanaraujo.backend_pos.application.service.auth.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.juanaraujo.backend_pos.application.service.auth.AuthService;
import com.juanaraujo.backend_pos.domain.exception.BusinessException;
import com.juanaraujo.backend_pos.domain.model.user.User;
import com.juanaraujo.backend_pos.domain.repository.user.UserRepository;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginRequest;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.LoginResponseDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.RegisterRequestDTO;
import com.juanaraujo.backend_pos.infraestructure.security.JwtService;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("Usuario no encontrado", 404));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException("Contraseña incorrecta", 401);
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

    @Override
    public LoginResponseDTO register(RegisterRequestDTO request) {

        // 🔒 Validar si ya existe
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new BusinessException("El usuario ya existe", 409);
        }

        // 🔐 Encriptar contraseña
        String encryptedPassword = passwordEncoder.encode(request.getPassword());

        // 👤 Crear usuario con rol fijo
        User user = User.builder()
                .username(request.getUsername())
                .password(encryptedPassword)
                .role("USER") // 🔥 SIEMPRE desde backend
                .build();

        userRepository.save(user);

        // 🔑 Generar token
        String token = jwtService.generateToken(user.getUsername(), user.getRole());

        // 🎯 Construir response desde el token (como definiste antes)
        return LoginResponseDTO.builder()
                .username(jwtService.extractUsername(token))
                .role(jwtService.extractRole(token))
                .token(token)
                .build();
    }

}