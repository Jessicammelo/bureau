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
public class LastBuy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite o preço")
	private Double price;
	
	@NotNull(message = "Digite a data da ultima compra")
	private Date lastBuy;
	
	@NotNull(message = "Digite uma descrição")
	@NotEmpty(message = "A descrição não pode ser vazio")
	@Size(min = 11, max = 20, message = "A descrição deve conter de 3 a 250 caracteres")
	private String description;
	
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getLastBuy() {
		return lastBuy;
	}

	public void setLastBuy(Date lastBuy) {
		this.lastBuy = lastBuy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
