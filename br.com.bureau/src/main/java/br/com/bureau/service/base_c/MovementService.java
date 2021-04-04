package br.com.bureau.service.base_c;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_c.LastBuy;
import br.com.bureau.models.base_c.Movement;
import br.com.bureau.repository.base_c.MovementRepository;
import br.com.bureau.service.base_a.PersonService;

@Service
public class MovementService {

	@Autowired
	private MovementRepository movementRepository;
	
	@Autowired
	private PersonService personService;
	
	public Movement create(Movement movement) {
		if (movement.getPerson() != null && movement.getPerson().getId() != null) {
			Person person = personService.findById(movement.getPerson().getId());
			movement.setPerson(person);
		}
		return movementRepository.save(movement);
	}
	
	public Movement findById(Long id) {
		Optional<Movement> movement = movementRepository.findById(id);
		if (movement.isPresent()) {
			return movement.get();
		} else {
			throw new NotFoundException("Não existe..");
		}
	}
	
	public List<Movement> getMovementByPerson(Long personId) {
		Person person = personService.findById(personId);
		return movementRepository.findByPerson(person);
	}
}
