package br.com.bureau.service.base_b;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureau.exception.NotFoundException;
import br.com.bureau.models.base_a.Person;
import br.com.bureau.models.base_b.Assets;
import br.com.bureau.repository.base_b.AssetsRepository;
import br.com.bureau.service.base_a.PersonService;

@Service
public class AssetsService {

	@Autowired
	private AssetsRepository assetsRepository;
	
	@Autowired
	private PersonService personService;
	
	public Assets create(Assets assets) {
		if (assets.getPerson() != null && assets.getPerson().getId() != null) {
			Person person = personService.findById(assets.getPerson().getId());
			assets.setPerson(person);
		}
		return assetsRepository.save(assets);
	}
	
	public Assets findById(Long id) {
		Optional<Assets> assets = assetsRepository.findById(id);
		if (assets.isPresent()) {
			return assets.get();
		} else {
			throw new NotFoundException("Este bem não existe..");
		}
	}
	
	public void delete(Long id) {
		Assets assets = findById(id);
		this.assetsRepository.delete(assets);
	}
	
	public Assets update(Long id, Assets assets) {
		Assets assetsFinded = findById(id);
		assetsFinded.setDescription(assets.getDescription());
		assetsFinded.setName(assets.getName());
		assetsFinded.setPrice(assets.getPrice());
		return assetsRepository.save(assetsFinded);
	}

	public List<Assets> getAssetsByPerson(Long personId) {
		Person person = personService.findById(personId);
		return assetsRepository.findByPerson(person);
	}


}
