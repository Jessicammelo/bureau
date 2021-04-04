package br.com.bureau.service.base_c;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_c.LastSearch;
import br.com.bureau.repository.base_c.LastSearchRepository;
import br.com.bureau.service.base_a.PersonService;

@Service
public class LastSearchService {

	@Autowired
	private LastSearchRepository lastSearchRepository;
	
	@Autowired
	private PersonService personService;
	
	public LastSearch create(LastSearch lastSearch) {
		if (lastSearch.getPerson() != null && lastSearch.getPerson().getId() != null) {
			Person person = personService.findById(lastSearch.getPerson().getId());
			lastSearch.setPerson(person);
		}
		return lastSearchRepository.save(lastSearch);
	}

	public LastSearch findById(Long id) {
		Optional<LastSearch> lastSearch = lastSearchRepository.findById(id);
		if (lastSearch.isPresent()) {
			return lastSearch.get();
		} else {
			throw new NotFoundException("Não existe..");
		}
	}
	
	public List<LastSearch> getLastSearchByPerson(Long personId) {
		Person person = personService.findById(personId);
		return lastSearchRepository.findByPerson(person);
	}
}
