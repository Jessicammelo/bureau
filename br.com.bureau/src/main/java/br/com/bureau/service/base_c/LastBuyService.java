package br.com.bureau.service.base_c;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_c.LastBuy;
import br.com.bureau.repository.base_c.LastBuyRepository;
import br.com.bureau.service.base_a.PersonService;

@Service
public class LastBuyService {

	@Autowired
	private LastBuyRepository lastBuyRepository;
	
	@Autowired
	private PersonService personService;
	
	public LastBuy create(LastBuy lastBuy) {
		if (lastBuy.getPerson() != null && lastBuy.getPerson().getId() != null) {
			Person person = personService.findById(lastBuy.getPerson().getId());
			lastBuy.setPerson(person);
		}
		return lastBuyRepository.save(lastBuy);
	}
	
	public LastBuy findById(Long id) {
		Optional<LastBuy> lastBuy = lastBuyRepository.findById(id);
		if (lastBuy.isPresent()) {
			return lastBuy.get();
		} else {
			throw new NotFoundException("Não existe..");
		}
	}
	
	public List<LastBuy> getLastBuyByPerson(Long personId) {
		Person person = personService.findById(personId);
		return lastBuyRepository.findByPerson(person);
	}
	
}
