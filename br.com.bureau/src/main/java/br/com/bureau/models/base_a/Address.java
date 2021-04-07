package br.com.bureau.models.base_a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Digite o país")
	@NotEmpty(message = "O país não pode ser vazio")
	@Size(min = 2, max = 100, message = "O país deve conter de 2 a 100 caracteres")
	private String country;
	
	@NotNull(message = "Digite o estado")
	@NotEmpty(message = "O estado não pode ser vazio")
	@Size(min = 2, max = 100, message = "O estado deve conter de 2 a 100 caracteres")
	private String state;
	
	@NotNull(message = "Digite a cidade")
	@NotEmpty(message = "A cidade não pode ser vazia")
	@Size(min = 2, max = 100, message = "A cidade deve conter de 2 a 100 caracteres")
	private String city;
	
	@NotNull(message = "Digite o bairro")
	@NotEmpty(message = "O bairro não pode ser vazio")
	@Size(min = 2, max = 100, message = "O bairro deve conter de 2 a 100 caracteres")
	private String district;
	
	@NotNull(message = "Digite o CEP")
	@NotEmpty(message = "O CEP não pode ser vazio")
	@Size(min = 7, max = 20, message = "O documento deve conter de 7 a 20 caracteres")
	private String zipCode;
	
	@NotNull(message = "Digite a rua")
	@NotEmpty(message = "A rua não pode ser vazia")
	@Size(min = 3, max = 100, message = "O documento deve conter de 3 a 100 caracteres")
	private String street;
	
	@NotNull(message = "Digite o número")
	@NotEmpty(message = "O número não pode ser vazio")
	@Size(min = 1, max = 20, message = "O número deve conter de 1 a 20 caracteres")
	private String number;
	
	@OneToOne
	@NotNull(message = "Digite uma pessoa")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
