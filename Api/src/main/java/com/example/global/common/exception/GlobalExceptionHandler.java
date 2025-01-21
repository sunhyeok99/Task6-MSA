package com.example.global.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        return ResponseEntity.status(ex.getErrorCode().getStatus()).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", ex.getErrorCode().getStatus(),
                        "error", "Error Code: " + ex.getClass().getSimpleName(),
                        "message", ex.getErrorCode().getMessage()
                )
        );
    }
}
