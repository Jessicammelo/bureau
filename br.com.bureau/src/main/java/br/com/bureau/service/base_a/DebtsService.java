package br.com.bureau.service.base_a;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Debts;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.repository.base_a.DebtsRepository;

@Service
public class DebtsService {

	@Autowired
	private DebtsRepository debtsRepository;
	
	@Autowired
	private PersonService personService;
	
	public Debts create(Debts debts) {
		if (debts.getPerson() != null && debts.getPerson().getId() != null) {
			Person person = personService.findById(debts.getPerson().getId());
			debts.setPerson(person);
		}
		return debtsRepository.save(debts);
	}
	
	public Debts findById(Long id) {
		Optional<Debts> debts = debtsRepository.findById(id);
		if (debts.isPresent()) {
			return debts.get();
		} else {
			throw new NotFoundException("Não possui dívidas.");
		}
	}

	public void delete(Long id) {
		Debts debts = findById(id);
		this.debtsRepository.delete(debts);
	}
		
	public List<Debts> getDebtsByPerson(Long personId) {
		Person person = personService.findById(personId);
		return debtsRepository.findByPerson(person);
	}

}
