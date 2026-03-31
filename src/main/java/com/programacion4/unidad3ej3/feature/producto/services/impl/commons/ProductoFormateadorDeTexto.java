package com.programacion4.unidad3ej3.feature.producto.services.impl.commons;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.iProductoFormateadorDeTexto;

@Service
public class ProductoFormateadorDeTexto implements iProductoFormateadorDeTexto{
        @Override
    public String CapitalizarTexto(String texto) {
        if (texto == null) {
            return null;
        }

        String textoNormalizado = texto.trim().toLowerCase(Locale.ROOT);
        if (textoNormalizado.isEmpty()) {
            return textoNormalizado;
        }

        return Character.toUpperCase(textoNormalizado.charAt(0)) + textoNormalizado.substring(1);
    };
}
