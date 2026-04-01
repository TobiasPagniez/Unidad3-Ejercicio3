package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoReadByIdService;

@Service
public class ProductoReadByIdService implements IProductoReadByIdService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto execute(Long id) {
        
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto con el ID: " + id));

        return ProductoMapper.toResponseDto(producto);
    }
}