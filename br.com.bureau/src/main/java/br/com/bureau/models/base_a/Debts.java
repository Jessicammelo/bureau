package br.com.bureau.models.base_a;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Debts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite uma descrição")
	@NotEmpty(message = "A descrição não pode ser vazio")
	@Size(min = 1, max = 250, message = "A descrição deve conter de 1 a 250 caracteres")
	private String description;
	
	@NotNull(message = "Digite a data de compra")
	private Date saleDate;
	
	@NotNull(message = "Digite a data do vencimento")
	private Date dueDate;
	
	@NotNull(message = "Digite o preço")
	private Double price;
	
	@OneToOne
	@NotNull(message = "Digite uma pessoa")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
	
}
