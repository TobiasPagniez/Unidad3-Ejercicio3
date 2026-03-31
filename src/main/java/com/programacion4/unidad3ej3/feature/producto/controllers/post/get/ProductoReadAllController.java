package com.programacion4.unidad3ej3.feature.producto.controllers.post.get; // Esta ruta está bien

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoReadAllService;

@RestController
@RequestMapping("/productos")
public class ProductoReadAllController {

    @Autowired
    private IProductoReadAllService readAllService;

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> readAll() {
        return ResponseEntity.ok(readAllService.execute());
    }
}