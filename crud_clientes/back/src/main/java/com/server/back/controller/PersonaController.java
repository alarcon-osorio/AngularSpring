package com.server.back.controller;

import com.server.back.entity.Persona;
import com.server.back.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 3600)
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/personas") //Trae toda data
    public List<Persona> listar(){
        return personaService.listar();
    }

    @PostMapping("/personas") //Inserta data
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

}
