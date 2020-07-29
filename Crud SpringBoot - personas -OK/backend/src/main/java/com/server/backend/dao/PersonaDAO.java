package com.server.backend.dao;

import com.server.backend.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDAO extends CrudRepository<Persona, Integer>{
    
}
