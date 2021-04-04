package br.com.bureau.repository.base_a;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureau.models.base_a.Address;
import br.com.bureau.models.base_a.Person;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByPerson(Person person);
	
	
}
