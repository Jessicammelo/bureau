package br.com.bureau.controller.base_a;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bureau.models.base_a.Debts;
import br.com.bureau.service.base_a.DebtsService;

@RestController
@RequestMapping("/debts")
public class DebtsController {
	
	@Autowired
	private DebtsService debtsService;

	@PostMapping
	public Debts create(@Valid @RequestBody Debts debts) {
		return debtsService.create(debts);
	}
	
	@GetMapping("/{id}")
	public Debts findById(@PathVariable Long id) {
		return debtsService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		debtsService.delete(id);
	}
}
