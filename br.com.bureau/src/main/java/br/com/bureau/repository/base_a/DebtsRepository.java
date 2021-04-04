package br.com.bureau.repository.base_a;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureau.models.base_a.Debts;
import br.com.bureau.models.base_a.Person;

@Repository
public interface DebtsRepository extends JpaRepository<Debts, Long>{

	List<Debts> findByPerson(Person person);
}
