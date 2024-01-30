package ar.com.templateit.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.templateit.model.Persona;
import ar.com.templateit.repository.PersonaRepository;

@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/personas")
	public List<Persona> obtenerTodos(){
		return personaRepository.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public Persona obtenerPorId(@PathVariable("id") long id) {
		return personaRepository.findById(id).get();
	}
	
	@PostMapping("/personas")
	public Persona crear(@RequestBody Persona persona) {
		return personaRepository.save(persona);
	}
	
	@PutMapping("/personas/{id}")
	public Persona actualizar(@PathVariable("id") long id,@RequestBody Persona persona) {
		Persona _persona = personaRepository.findById(id).get();
		
		if(Objects.nonNull(_persona)) {
			_persona.setEmail(persona.getEmail());
			_persona.setNombres(persona.getNombres());
			personaRepository.save(_persona);	
		}
		
		return _persona;
		
	}
	
	@DeleteMapping("/personas/{id}")
	public void eliminar(@PathVariable("id") long id) {
		personaRepository.deleteById(id);
	}
}
