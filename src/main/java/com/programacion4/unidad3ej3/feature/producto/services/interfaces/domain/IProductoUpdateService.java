package com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;

@Service
public interface IProductoUpdateService {
    ProductoResponseDto execute(Long id, ProductoUpdateRequestDto updateDto);
}