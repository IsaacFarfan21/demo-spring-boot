package com.utec.demo.spring_boot.controllers;

import com.utec.demo.spring_boot.producto.Producto;
import com.utec.demo.spring_boot.producto.ProductoDTO;
import com.utec.demo.spring_boot.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.ModuleElement;
import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService=productoService;
    }

    @GetMapping
    public List<Producto> listaProductos(){
        return productoService.listar();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.crear(productoDTO);

    }
    @GetMapping("/{id}")
    public Producto obtenerPorducto(@PathVariable long id)
    {
        return productoService.obtenerPorId(id);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable long id){
        boolean notaEliminada= productoService.eliminar(id);
        if(notaEliminada=true){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
