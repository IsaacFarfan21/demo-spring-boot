package com.utec.demo.spring_boot.controllers;

import com.utec.demo.spring_boot.producto.Producto;
import com.utec.demo.spring_boot.producto.ProductoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @GetMapping
    public List<Producto> listaProductos(){
        return BD;
    }
    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDTO) {
        Producto nuevoProducto = new Producto(NEXT_ID.getAndIncrement(), productoDTO.getNombre(),
                productoDTO.getPrecio()) ;
        BD.add(nuevoProducto);
        return nuevoProducto;
    }
    @GetMapping("/{id}")
    public Producto obtenerPorducto(@PathVariable long id)
    {
        return BD.stream()
                .filter(p -> p.getId()
                ==id)
                .findFirst()
                .orElse(null);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable long id){
        boolean notaEliminada= BD.removeIf(p->p.getId()==id);
        if(notaEliminada=true){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
