package br.com.bureau.service.base_b;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_b.Income;
import br.com.bureau.repository.base_b.IncomeRepository;
import br.com.bureau.service.base_a.PersonService;

@Service
public class IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private PersonService personService;

	public Income create(Income income) {
		if (income.getPerson() != null && income.getPerson().getId() != null) {
			Person person = personService.findById(income.getPerson().getId());
			income.setPerson(person);
		}
		return incomeRepository.save(income);
	}
	
	public Income findById(Long id) {
		Optional<Income> income = incomeRepository.findById(id);
		if (income.isPresent()) {
			return income.get();
		} else {
			throw new NotFoundException("Não possui renda...");
		}
	}
	
	public void delete(Long id) {
		Income income = findById(id);
		this.incomeRepository.delete(income);
	}
	
	public Income update(Long id, Income income) {
		Income incomeFinded = findById(id);
		incomeFinded.setCompany(income.getCompany());
		incomeFinded.setSalary(income.getSalary());
		return incomeRepository.save(incomeFinded);
	}
	
	public List<Income> getIncomeByPerson(Long personId) {
		Person person = personService.findById(personId);
		return incomeRepository.findByPerson(person);
	}
}
