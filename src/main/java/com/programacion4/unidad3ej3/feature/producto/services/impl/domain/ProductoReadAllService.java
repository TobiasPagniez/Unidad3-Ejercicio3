package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoReadAllService; // Ojo aquí: fijate dónde guardaste la interfaz
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import java.util.List;

@Service
public class ProductoReadAllService implements IProductoReadAllService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
public List<ProductoResponseDto> execute() {
    List<Producto> productos = (List<Producto>) productoRepository.findAll();
    List<ProductoResponseDto> respuesta = new ArrayList<>();

    for (Producto p : productos) {
        // Llamamos al método estático usando ProductoMapper.nombreMetodo
        respuesta.add(ProductoMapper.toResponseDto(p)); 
    }

    return respuesta;
}
}