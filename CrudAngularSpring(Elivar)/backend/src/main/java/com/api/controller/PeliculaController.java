package com.api.controller;

import com.api.model.Pelicula;
import com.api.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    //Metodo para obtener
    @GetMapping("/api/peliculas")
    public ResponseEntity<List<Pelicula>> getPeliculas(){
        List<Pelicula> list = peliculaService.list();
        return ResponseEntity.ok().body(list);
    }

    //Metodo guardar
    @PostMapping("/api/pelicula")
    public ResponseEntity<?> save(@RequestBody Pelicula pelicula) {
        long id = peliculaService.save(pelicula);
        return ResponseEntity.ok().body("la pelicula con id: "+ id + " ha sido guardada correctamente");
    }

    //Metodo obtener por ID
    @GetMapping("/api/pelicula/{id}")
    public ResponseEntity<Pelicula> get(@PathVariable("id") long id){
        Pelicula pelicula = peliculaService.get(id);
        return ResponseEntity.ok().body(pelicula);
    }

    //Metodo Actualizar
    @PutMapping("/api/pelicula/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Pelicula pelicula) {
        peliculaService.update(id, pelicula);
        return ResponseEntity.ok().body("Pelicula ha sido actualizada correctamente");
    }

}
