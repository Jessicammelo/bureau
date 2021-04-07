package br.com.bureau.service.base_a;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.ConflictedException;
import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Address;
import br.com.bureau.models.base_a.Debts;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_b.Assets;
import br.com.bureau.models.base_b.Income;
import br.com.bureau.models.base_c.LastBuy;
import br.com.bureau.models.base_c.LastSearch;
import br.com.bureau.models.base_c.Movement;
import br.com.bureau.repository.base_a.PersonRepository;
import br.com.bureau.service.base_b.AssetsService;
import br.com.bureau.service.base_b.IncomeService;
import br.com.bureau.service.base_c.LastBuyService;
import br.com.bureau.service.base_c.LastSearchService;
import br.com.bureau.service.base_c.MovementService;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private DebtsService debtsService;
	
	@Autowired
	private AssetsService assetsService;
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private LastBuyService buyService;
	
	@Autowired
	private LastSearchService lastSearchService;
	
	@Autowired
	private MovementService movementService;
	
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
		List<Address> addresses = addressService.getAddressByPerson(id);
		if (addresses == null || !addresses.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem endereços cadastrados");
		}
		List<Debts> debts = debtsService.getDebtsByPerson(id);
		if (debts == null || !debts.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem débitos cadastrados");
		}
		List<Assets> assets = assetsService.getAssetsByPerson(id);
		if (assets == null || !assets.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem bens cadastrados");
		}
		List<Income> income = incomeService.getIncomeByPerson(id);
		if (income == null || !income.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem rendas cadastradas");
		}
		List<LastBuy> lastBuy = buyService.getLastBuyByPerson(id);
		if (lastBuy == null || !lastBuy.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem compras cadastradas");
		}
		List<LastSearch> lastSearch = lastSearchService.getLastSearchByPerson(id);
		if (lastSearch == null || !lastSearch.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem pesquisas cadastrados");
		}
		List<Movement> movement = movementService.getMovementByPerson(id);
		if (movement == null || !movement.isEmpty()) {
			throw new ConflictedException("A pessoa não pode ser apagada porque existem movimentações cadastrados");
		}
		this.personRepository.delete(person);
	}
	
	public Person update(Long id, Person person) {
		Person personFinded = findById(id);
		personFinded.setName(person.getName());
		return personRepository.save(personFinded);
	}
	
	
	
}
