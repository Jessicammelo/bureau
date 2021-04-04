package br.com.bureau.service.base_a;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.repository.base_a.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person findByDocument(String document) {
		List<Person> person = personRepository.findByDocument(document);
		if (person != null && !person.isEmpty()) {
			return person.get(0);
		} else {
			throw new NotFoundException("A pessoa não existe!...");
		}
	}
	
	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			throw new NotFoundException("A pessoa não existe!...");
		}
	}
	
	public void delete(Long id) {
		Person person  = findById(id);
		this.personRepository.delete(person);
	}
	
	public Person update(Long id, Person person) {
		Person personFinded = findById(id);
		personFinded.setName(person.getName());
		return personRepository.save(personFinded);
	}
	
	
	
}
