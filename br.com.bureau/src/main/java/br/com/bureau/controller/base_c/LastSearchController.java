package br.com.bureau.controller.base_c;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bureau.models.base_c.LastSearch;
import br.com.bureau.service.base_c.LastSearchService;

@RestController
@RequestMapping("/lastSearchs")
public class LastSearchController {

	@Autowired
	private LastSearchService lastSearchService;
	
	@PostMapping
	public LastSearch create(@Valid @RequestBody LastSearch lastSearch) {
		return lastSearchService.create(lastSearch);
	}
	
	@GetMapping("/{id}")
	public LastSearch findById(@PathVariable Long id) {
		return lastSearchService.findById(id);
	}
}
