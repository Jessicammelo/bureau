package br.com.bureau.models.base_c;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bureau.models.base_a.Person;

@Entity
public class LastSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite a date da busca")
	private Date lastSearch;
	
	@NotNull(message = "Digite qual Bureau")
	@NotEmpty(message = "O Bureau não pode ser vazio")
	@Size(min = 11, max = 20, message = "O Bureau deve conter de 3 a 250 caracteres")
	private String bureau;
	
	@OneToOne
	@NotNull(message = "Digite uma pessoa")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastSearch() {
		return lastSearch;
	}

	public void setLastSearch(Date lastSearch) {
		this.lastSearch = lastSearch;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
}
