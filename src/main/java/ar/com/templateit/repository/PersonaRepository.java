package ar.com.templateit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.templateit.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	Persona findByNombres(String nombres);
	
	Persona findByEmail(String email);

}
