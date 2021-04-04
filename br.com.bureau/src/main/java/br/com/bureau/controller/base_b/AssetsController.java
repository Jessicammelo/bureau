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

import br.com.bureau.models.base_b.Assets;
import br.com.bureau.service.base_b.AssetsService;

@RestController
@RequestMapping("/assets")
public class AssetsController {

	@Autowired
	private AssetsService assetsService;
	
	@PostMapping
	public Assets create(@Valid @RequestBody Assets assets) {
		return assetsService.create(assets);
	}
	
	@GetMapping("/{id}")
	public Assets findById(@PathVariable Long id) {
		return assetsService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		assetsService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Assets update(@PathVariable Long id,@Valid @RequestBody Assets assets) {
		return assetsService.update(id, assets);
	}
}
