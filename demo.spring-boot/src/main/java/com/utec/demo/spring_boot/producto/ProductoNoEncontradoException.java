package com.utec.demo.spring_boot.producto;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(long id){
        super ("Producto " + id+ "no encontrado");
    }

}
