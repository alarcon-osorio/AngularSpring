package com.server.back.service;

import com.server.back.entity.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> listar();
    Persona listarId(int id);
    Persona save(Persona persona);
    Persona edit(Persona persona);
    Persona delete(int id);

}
