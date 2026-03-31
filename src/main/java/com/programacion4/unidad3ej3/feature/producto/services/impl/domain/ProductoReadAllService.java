package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import java.util.ArrayList;
import java.util.List; // Ojo aquí: fijate dónde guardaste la interfaz

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoReadAllService;

@Service
public class ProductoReadAllService implements IProductoReadAllService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<ProductoResponseDto> execute() {
    List<Producto> productos = (List<Producto>) productoRepository.findAll();
    List<ProductoResponseDto> respuesta = new ArrayList<>();

    for (Producto p : productos) {
        respuesta.add(ProductoMapper.toResponseDto(p)); 
    }

    return respuesta;
}
}