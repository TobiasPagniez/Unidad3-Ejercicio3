package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.BadRequestException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductoExistByNameService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.iProductoFormateadorDeTexto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoCreateService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductoCreateService implements IProductoCreateService {

    private final IProductoExistByNameService productoExistByNameService;

    private final IProductoRepository productoRepository;

    private final iProductoFormateadorDeTexto productoFormateadorDeTexto; 

    @Override
    public ProductoResponseDto create(ProductoCreateRequestDto dto) {

        dto.setNombre(productoFormateadorDeTexto.CapitalizarTexto(dto.getNombre()));
        dto.setDescripcion(productoFormateadorDeTexto.CapitalizarTexto(dto.getDescripcion()));

        if (productoExistByNameService.existByName(dto.getNombre())) {
            throw new BadRequestException("El nombre del producto ya existe");
        }

        Producto productoAGuardar = ProductoMapper.toEntity(dto);
        
        Producto productoGuardado = productoRepository.save(productoAGuardar);

        return ProductoMapper.toResponseDto(productoGuardado);
    }
}
