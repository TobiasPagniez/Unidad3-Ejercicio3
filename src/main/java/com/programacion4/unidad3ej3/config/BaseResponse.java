package com.programacion4.unidad3ej3.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private
    String message;
    private List<String> errors;
    private String timestamp;
    private T data;
    private Integer status; 
    private String path;
}