package com.api.controller;

import com.api.model.Pelicula;
import com.api.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
