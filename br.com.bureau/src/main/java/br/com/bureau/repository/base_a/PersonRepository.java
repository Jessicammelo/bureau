package br.com.bureau.repository.base_a;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureau.models.base_a.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	
	 List<Person> findByDocument(String document);
}
