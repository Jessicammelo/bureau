package br.com.bureau.models.base_b;

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
public class Assets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite o nome")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Size(min = 11, max = 20, message = "O nome deve conter de 3 a 250 caracteres")
	private String name;
	
	@NotNull(message = "Digite a descrição")
	@NotEmpty(message = "A descrição não pode ser vazio")
	@Size(min = 11, max = 20, message = "A descrição deve conter de 3 a 250 caracteres")
	private String description;
	
	@NotNull(message = "Digite o preço")
	private Double price;
	
	@OneToOne
	@NotNull(message = "Digite uma pessoa")
	private Person person;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
