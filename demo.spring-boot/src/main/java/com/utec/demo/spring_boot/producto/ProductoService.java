package com.utec.demo.spring_boot.producto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {
    private static final List<Producto> BD = new ArrayList<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(1L);

    public List<Producto> listar(){
        return BD;
    }

    public Producto crear(ProductoDTO productoDTO) {
        Producto nuevoProducto = new Producto(NEXT_ID.getAndIncrement(), productoDTO.getNombre(),
                productoDTO.getPrecio()) ;
        BD.add(nuevoProducto);
        return nuevoProducto;
    }
    public Producto obtenerPorId( long id)
    {
        return BD.stream()
                .filter(p -> p.getId()
                        ==id)
                .findFirst()
                .orElseThrow(()-> new ProductoNoEncontradoException(id));
    }
    public boolean eliminar(long id){
        boolean productoEliminado =  BD.removeIf(p->p.getId()==id);
        if(!productoEliminado){
            throw new ProductoNoEncontradoException(id);
        }
        return productoEliminado;
    }
}
