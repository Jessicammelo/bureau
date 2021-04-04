package br.com.bureau.models.base_a;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite o documento")
	@NotEmpty(message = "O documento não pode ser vazio")
	@Size(min = 11, max = 20, message = "O documento deve conter de 11 a 20 caracteres")
	private String document;
	
	@NotNull(message = "Digite o nome")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Size(min = 11, max = 20, message = "O nome deve conter de 3 a 250 caracteres")
	private String name;
	
	@NotNull(message = "Digite a data de nascimento")
	private Date birthDate;

	public Long getId() {
		return id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
