package com.Tournament.Tournament.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // Validation errors -> 400 Bad Request
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
    List<String> details = ex.getBindingResult().getFieldErrors().stream()
        .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
        .collect(Collectors.toList());

    ApiError body = new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad Request", "Validation failed", request.getRequestURI());
    body.setErrors(details);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }

  // Any other exception -> 500 Internal Server Error
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleAll(Exception ex, HttpServletRequest request) {
    ApiError body = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
  }
}
