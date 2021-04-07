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
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite a empresa")
	@NotEmpty(message = "A empresa não pode ser vazio")
	@Size(min = 2, max = 250, message = "A empresa deve conter de 2 a 250 caracteres")
	private String company;
	
	@NotNull(message = "Digite o valor da renda")
	private Double salary;
	
	@OneToOne
	@NotNull(message = "Digite uma pessoa")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
