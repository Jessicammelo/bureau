package br.com.bureau.repository.base_b;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_b.Assets;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, Long>{

	 List<Assets> findByPerson(Person person);
}
