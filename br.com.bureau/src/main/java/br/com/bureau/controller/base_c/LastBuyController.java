package br.com.bureau.controller.base_c;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bureau.models.base_c.LastBuy;
import br.com.bureau.service.base_c.LastBuyService;

@RestController
@RequestMapping("/lastBuys")
public class LastBuyController {

	@Autowired
	private LastBuyService lastBuyService;
	
	@PostMapping
	public LastBuy create(@Valid @RequestBody LastBuy lastBuy) {
		return lastBuyService.create(lastBuy);
	}
	
	@GetMapping("/{id}")
	public LastBuy findById(@PathVariable Long id) {
		return lastBuyService.findById(id);
	}
	
}
