package com.utec.demo.spring_boot.controllers;

import com.utec.demo.spring_boot.producto.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @GetMapping
    public List<Producto> listaProductos(){
        return List.of(
                new Producto(1L,"producto A",20.0),
                new Producto(2L,"producto B",100.0),
                new Producto(3L,"producto C",30.0)
        );
    }
}
