package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;

@Service
public class ProductoUpdateService implements IProductoUpdateService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto execute(Long id, ProductoUpdateRequestDto updateDto) {
        
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se puede actualizar: No existe el producto con ID: " + id));

        
        productoExistente.setNombre(updateDto.getNombre());
        productoExistente.setCodigo(updateDto.getCodigo());
        productoExistente.setDescripcion(updateDto.getDescripcion());
        productoExistente.setPrecio(updateDto.getPrecio());
        productoExistente.setStock(updateDto.getStock());

        
        Producto productoActualizado = productoRepository.save(productoExistente);

        
        return ProductoMapper.toResponseDto(productoActualizado);
    }
}