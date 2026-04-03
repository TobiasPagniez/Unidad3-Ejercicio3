package com.programacion4.unidad3ej3.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.util.List;

import com.programacion4.unidad3ej3.config.exceptions.CustomException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones personalizadas (Incluye NotFound y Conflict)
     * @param ex La excepción personalizada
     * @param request El objeto de la petición para obtener el path
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<Object>> handleCustomException(CustomException ex, HttpServletRequest request) {
        BaseResponse<Object> response = BaseResponse.builder()
                .message(ex.getMessage())
                .errors(ex.getErrors())
                .status(ex.getStatus().value()) // Código de estado numérico
                .path(request.getRequestURI())   // Path de la url
                .timestamp(Instant.now().toString())
                .build();

        return new ResponseEntity<>(response, ex.getStatus());
    }

    /**
     * Maneja las excepciones de validación (US04 - Campos no nulos)
     * @param ex La excepción de validación
     * @param request El objeto de la petición para obtener el path
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .toList();

        BaseResponse<Object> response = BaseResponse.builder()
                .message("Error de validación")
                .errors(errors)
                .status(400) // Bad Request
                .path(request.getRequestURI())
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    /**
     * Maneja las excepciones genéricas
     * @param ex La excepción genérica
     * @param request El objeto de la petición para obtener el path
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneric(Exception ex, HttpServletRequest request) {
        BaseResponse<Object> response = BaseResponse.builder()
                .message("Ocurrió un error inesperado")
                .errors(List.of("Contacte al administrador"))
                .status(500) // Internal Server Error
                .path(request.getRequestURI())
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.internalServerError().body(response); 
    }
}