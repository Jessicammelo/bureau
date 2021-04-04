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
import br.com.bureau.service.base_a.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public Address create(@Valid @RequestBody Address address) {
		return addressService.create(address);
	}
	
	@GetMapping("/{id}")
	public Address findById(@PathVariable Long id) {
		return addressService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
	}
	
	@GetMapping
	public List<Address> listAddress() {
		return addressService.listAddress();
	}
	
	@PutMapping("/{id}")
	public Address update(@PathVariable Long id,@Valid @RequestBody Address address) {
		return addressService.update(id, address);
	}
}
