package com.utec.demo.spring_boot.producto;

public class Producto {

    private long id;
    private String nombre;
    private Double precio;

    public Producto(long id, String nombre, Double precio){
        this.id= id;
        this.nombre = nombre;
        this.precio = precio;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
