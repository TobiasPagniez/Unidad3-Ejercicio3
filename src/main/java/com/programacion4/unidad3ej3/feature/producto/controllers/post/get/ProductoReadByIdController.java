package com.programacion4.unidad3ej3.feature.producto.controllers.post.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoReadByIdService;

@RestController
@RequestMapping("/productos")
public class ProductoReadByIdController {

    @Autowired
    private IProductoReadByIdService readByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(readByIdService.execute(id));
    }
}