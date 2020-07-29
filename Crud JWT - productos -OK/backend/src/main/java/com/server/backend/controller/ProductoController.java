package com.server.backend.controller;

//import com.server.backend.DTO.Mensaje;
import com.server.backend.entity.Producto;
import com.server.backend.service.ProductoService;
//import org.apache.commons.lang3.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = {"http://150.136.217.38:4200"}, maxAge = 3600)
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @GetMapping("/lista")
    public List<Producto> getLista(){
       return productoService.obtenerTodos();
        
    }

    @GetMapping("/detalle/{id}")
    public Producto getOne(@PathVariable Long id){
        return productoService.obtenerPorId(id).get();
    }

    @PostMapping("nuevo")
    @PreAuthorize("hasRole('ADMIN')")
    public void create(@RequestBody Producto producto){      
        productoService.guardar(producto);        
    }
   
    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void update(@RequestBody Producto producto, @PathVariable Long id){
        Producto prodUpdate = productoService.obtenerPorId(id).get();      
        
        prodUpdate.setNombreProducto(producto.getNombreProducto());
        prodUpdate.setPrecio(producto.getPrecio());
        
        productoService.guardar(prodUpdate);
        
    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id){        
        productoService.borrar(id);
    }
}
