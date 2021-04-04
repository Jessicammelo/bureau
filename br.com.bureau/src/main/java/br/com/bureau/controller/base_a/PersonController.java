package br.com.bureau.controller.base_a;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bureau.models.base_a.Address;
import br.com.bureau.models.base_a.Debts;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_b.Assets;
import br.com.bureau.models.base_b.Income;
import br.com.bureau.models.base_c.LastBuy;
import br.com.bureau.models.base_c.LastSearch;
import br.com.bureau.models.base_c.Movement;
import br.com.bureau.service.base_a.AddressService;
import br.com.bureau.service.base_a.DebtsService;
import br.com.bureau.service.base_a.PersonService;
import br.com.bureau.service.base_b.AssetsService;
import br.com.bureau.service.base_b.IncomeService;
import br.com.bureau.service.base_c.LastBuyService;
import br.com.bureau.service.base_c.LastSearchService;
import br.com.bureau.service.base_c.MovementService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private DebtsService debtsService;
	
	@Autowired
	private AssetsService assetsService;
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private LastSearchService lastSearchService;
	
	@Autowired
	private LastBuyService lastBuyService;
	
	@Autowired
	private MovementService movementService;	
	
	@PostMapping
	public Person create(@Valid @RequestBody Person person) {
		return personService.create(person);
	}
	
	@GetMapping("/{document}")
	public Person findById(@PathVariable String document) {
		return personService.findByDocument(document);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Person update(@PathVariable Long id,@Valid @RequestBody Person person) {
		return personService.update(id, person);
	}
	
	@GetMapping("/{id}/addresses")
	public List<Address> getAddress(@PathVariable Long id) {
		return addressService.getAddressByPerson(id);
	}
	

	@GetMapping("/{id}/debts")
	public List<Debts> getDebts(@PathVariable Long id) {
		return debtsService.getDebtsByPerson(id);
	}
	
	@GetMapping("/{id}/assets")
	public List<Assets> getAssets(@PathVariable Long id) {
		return assetsService.getAssetsByPerson(id);
	}
	
	@GetMapping("/{id}/incomes")
	public List<Income> getIncome(@PathVariable Long id) {
		return incomeService.getIncomeByPerson(id);
	}
	
	@GetMapping("/{id}/lastSearchs")
	public List<LastSearch> getLastSearch(@PathVariable Long id) {
		return lastSearchService.getLastSearchByPerson(id);
	}
	
	@GetMapping("/{id}/lastBuys")
	public List<LastBuy> getLastBuy(@PathVariable Long id) {
		return lastBuyService.getLastBuyByPerson(id);
	}
	
	@GetMapping("/{id}/movements")
	public List<Movement> getMovement(@PathVariable Long id) {
		return movementService.getMovementByPerson(id);
	}
}
