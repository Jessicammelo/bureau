package br.com.bureau.controller.base_c;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bureau.models.base_c.Movement;
import br.com.bureau.service.base_c.MovementService;

@RestController
@RequestMapping("/movements")
public class MovementController {

	@Autowired
	private MovementService movementService;
	
	@PostMapping
	public Movement create(@Valid @RequestBody Movement movement) {
		return movementService.create(movement);
	}
	
	@GetMapping("/{id}")
	public Movement findById(@PathVariable Long id) {
		return movementService.findById(id);
	}
}
