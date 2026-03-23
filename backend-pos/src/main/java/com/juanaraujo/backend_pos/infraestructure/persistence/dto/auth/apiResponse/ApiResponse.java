package com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private T data;
    private String message;
    private String error;
}