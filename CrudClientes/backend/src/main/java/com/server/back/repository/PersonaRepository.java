package com.server.back.repository;

import com.server.back.entity.Persona;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonaRepository extends Repository<Persona, Integer> {

    List<Persona> findAll();
    Persona findById(int id);
    Persona save(Persona persona);
    void delete(Persona persona);

}
