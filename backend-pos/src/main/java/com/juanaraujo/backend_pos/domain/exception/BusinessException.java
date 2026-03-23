package com.juanaraujo.backend_pos.domain.exception;

public class BusinessException extends RuntimeException {

    private final int status; 

    public BusinessException(String message) {
        super(message);
        this.status = 400; // default
    }

    public BusinessException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
