package com.programacion4.unidad3ej3.feature.producto.controllers.delete;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;

@RestController
@RequestMapping("/productos")
public class ProductoDeleteController {

    @Autowired
    private IProductoDeleteService deleteService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // devuelve el 204
    public void delete(@PathVariable Long id) {
        deleteService.execute(id);
    }
}