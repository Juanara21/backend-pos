package com.juanaraujo.backend_pos.infraestructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.juanaraujo.backend_pos.domain.exception.BusinessException;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.apiResponse.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusiness(BusinessException ex) {
        return ResponseEntity
                .status(ex.getStatus())  // aquí decides 401, 404, etc
                .body(new ApiResponse<>(null, null, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneral(Exception ex) {
        return ResponseEntity
                .status(500)
                .body(new ApiResponse<>(null, null, "Error interno del servidor"));
    }
}