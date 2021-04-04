package br.com.bureau.controller.base_b;

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

import br.com.bureau.models.base_b.Income;
import br.com.bureau.service.base_b.IncomeService;

@RestController
@RequestMapping("/incomes")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@PostMapping
	public Income create(@Valid @RequestBody Income income) {
		return incomeService.create(income);
	}
	
	@GetMapping("/{id}")
	public Income findById(@PathVariable Long id) {
		return incomeService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		incomeService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Income update(@PathVariable Long id,@Valid @RequestBody Income income) {
		return incomeService.update(id, income);
	}

}
