package com.server.back.service;

import com.server.back.entity.Persona;
import com.server.back.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    public Persona listarId(int id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona edit(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona delete(int id) {
        Persona persona = personaRepository.findById(id);
        if (persona != null){
            personaRepository.delete(persona);
        }
        return persona;
    }
}
