package com.api.service;

import com.api.model.Pelicula;

import java.util.List;

public interface PeliculaService {
    //Guardar
    long save(Pelicula pelicula);
    //Obtener una pelicula
    Pelicula get(long id);
    //Obtener lista de peliculas
    List<Pelicula> list();
    //Actualizar peliculas
    void update(long id, Pelicula pelicula);
    //Eliminar perlicupas
    void delete(long id);
}
