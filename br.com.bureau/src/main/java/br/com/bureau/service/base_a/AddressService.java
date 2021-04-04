package br.com.bureau.service.base_a;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Address;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.repository.base_a.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonService personService;

	public Address create(Address address) {
		if (address.getPerson() != null && address.getPerson().getId() != null) {
			Person person = personService.findById(address.getPerson().getId());
			address.setPerson(person);
		}
		return addressRepository.save(address);
	}

	public Address findById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		if (address.isPresent()) {
			return address.get();
		} else {
			throw new NotFoundException("O endereço não existe..");
		}
	}

	public void delete(Long id) {
		Address address = findById(id);
		this.addressRepository.delete(address);
	}

	public List<Address> listAddress() {
		return addressRepository.findAll();
	}

	public Address update(Long id, Address address) {
		Address addressFinded = findById(id);
		addressFinded.setCountry(address.getCountry());
		addressFinded.setCity(address.getCity());
		addressFinded.setDistrict(address.getDistrict());
		addressFinded.setState(address.getState());
		addressFinded.setNumber(address.getNumber());
		addressFinded.setStreet(address.getStreet());
		addressFinded.setZipCode(address.getZipCode());
		return addressRepository.save(addressFinded);
	}

	public List<Address> getAddressByPerson(Long personId) {
		Person person = personService.findById(personId);
		return addressRepository.findByPerson(person);
	}

}
