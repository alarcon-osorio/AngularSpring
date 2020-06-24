package com.server.backend.controller;

import com.server.backend.model.Persona;
import com.server.backend.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://150.136.217.38:4200"}, maxAge = 3600)
@RequestMapping("/api")
public class PersonaController {
    
    @Autowired
	private PersonaService personaService;
    
        @GetMapping("/personas") //Trae toda data
	public List<Persona> personas() {
            return personaService.findAll(); 
	}
    
        @GetMapping("/personas/{id}") //Trae un dato
	public Persona mostrar(@PathVariable Integer id) {
		return personaService.findById(id);
	}       
    
        @PostMapping("/personas") //Inserta data
	public Persona save(@RequestBody Persona persona) {
		return personaService.save(persona);
	}	
	
	@PutMapping("/personas/{id}") //Actualiza un dato
	public Persona update(@RequestBody Persona persona, @PathVariable Integer id) {
		Persona personaActual = personaService.findById(id);
		
                personaActual.setIdentificacion(persona.getIdentificacion());
		personaActual.setNombre(persona.getNombre());
		personaActual.setApellido(persona.getApellido());
                personaActual.setEdad(persona.getEdad());
		personaActual.setOcupacion(persona.getOcupacion());
                personaActual.setNombre(persona.getNombre());
		
		return personaService.save(personaActual);
	}
	
	@DeleteMapping("/personas/{id}") //Elimina un dato
	public void delete(@PathVariable Integer id) {
		personaService.delete(id);		
	}
    
}
