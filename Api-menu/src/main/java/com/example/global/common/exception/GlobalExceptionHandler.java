package com.example.global.common.exception;

import com.example.global.common.dto.FailResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException exc) {
        ErrorCode errorCode = exc.getErrorCode();

        return new ResponseEntity<>(
                FailResponse.of(String.valueOf(errorCode.getStatus()), errorCode.getMessage()),
                HttpStatusCode.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<FailResponse<Map<String, String>>> handleIllegalArgument(IllegalArgumentException exc) {
        String message = exc.getMessage();

        return new ResponseEntity<>(
                FailResponse.of("404", message),
                HttpStatusCode.valueOf(404));
    }
}
