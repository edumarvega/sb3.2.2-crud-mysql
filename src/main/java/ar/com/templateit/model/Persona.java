package ar.com.templateit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "email")
	private String email;
	
	public Persona() {
		
	}
	
	
	public Persona(String nombres, String email) {
		this.nombres = nombres;
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", email=" + email + "]";
	}
	
	

}
