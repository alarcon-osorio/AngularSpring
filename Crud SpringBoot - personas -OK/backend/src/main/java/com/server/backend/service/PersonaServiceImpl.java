package com.server.backend.service;

import com.server.backend.dao.PersonaDAO;
import com.server.backend.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDAO personaDao;

    @Override
    public List<Persona> findAll() {
       return (List<Persona>) personaDao.findAll();
    } 
    
    @Override
    public Persona findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }
    
    @Override
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    public void delete(Integer id) {
        personaDao.deleteById(id);
    } 
    
}
