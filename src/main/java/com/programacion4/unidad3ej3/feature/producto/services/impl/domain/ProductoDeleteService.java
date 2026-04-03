package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;

@Service
public class ProductoDeleteService implements IProductoDeleteService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void execute(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se puede eliminar: No existe el producto con ID: " + id));
        
        producto.setEstaEliminado(true);

        productoRepository.save(producto);
    }
}