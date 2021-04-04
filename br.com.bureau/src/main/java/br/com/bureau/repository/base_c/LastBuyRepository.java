package br.com.bureau.repository.base_c;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_c.LastBuy;

@Repository
public interface LastBuyRepository extends JpaRepository<LastBuy, Long> {
	
	List<LastBuy> findByPerson(Person person);

}
