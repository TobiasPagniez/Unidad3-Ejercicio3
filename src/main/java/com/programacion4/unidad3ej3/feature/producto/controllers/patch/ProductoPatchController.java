package com.programacion4.unidad3ej3.feature.producto.controllers.patch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;

@RestController
@RequestMapping("/productos")
public class ProductoPatchController {

    @Autowired
    private IProductoPatchService patchService;

    @PatchMapping("/{id}") 
    public ResponseEntity<ProductoResponseDto> patch(@PathVariable Long id, @RequestBody ProductoUpdateRequestDto patchDto) {
        return ResponseEntity.ok(patchService.execute(id, patchDto));
    }
}