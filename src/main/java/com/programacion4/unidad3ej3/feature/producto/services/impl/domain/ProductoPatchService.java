package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;

@Service
public class ProductoPatchService implements IProductoPatchService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto execute(Long id, ProductoUpdateRequestDto patchDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));

        if (patchDto.getPrecio() != null) {
            producto.setPrecio(patchDto.getPrecio());
        }
        if (patchDto.getStock() != null) {
            producto.setStock(patchDto.getStock());
        }

        return ProductoMapper.toResponseDto(productoRepository.save(producto));
    }
}