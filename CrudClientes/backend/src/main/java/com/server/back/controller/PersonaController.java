package com.server.back.controller;

import com.server.back.entity.Persona;
import com.server.back.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/personas/{id}") //Trae un dato
    public Persona mostrar(@PathVariable Integer id) {
        return personaService.listarId(id);
    }

    @PutMapping(path = {"(/{id}"})
    public Persona editar(@RequestBody Persona persona, @PathVariable("id") int id)  {
        persona.setId(id);
        return personaService.edit(persona);
    }

    @PutMapping("/personas/{id}") //Actualiza un dato
    public Persona update(@RequestBody Persona persona, @PathVariable Integer id) {
        Persona personaActual = personaService.listarId(id);

        personaActual.setNombre(persona.getNombre());
        personaActual.setApellidos(persona.getApellidos());

        return personaService.save(personaActual);
    }

    @DeleteMapping("/personas/{id}") //Elimina un dato
    public void delete(@PathVariable Integer id) {
        personaService.delete(id);
    }


    

}
