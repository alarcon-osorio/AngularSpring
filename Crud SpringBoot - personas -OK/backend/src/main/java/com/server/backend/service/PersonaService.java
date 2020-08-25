package com.server.backend.service;

import com.server.backend.model.Persona;
import java.util.List;


public interface PersonaService {
    
    public List<Persona> findAll();
    public Persona findById(Integer id);
    public Persona save(Persona persona);
    public void delete(Integer id); 
    
}
