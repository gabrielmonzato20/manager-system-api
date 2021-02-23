package com.coursedash.client.service;

import com.coursedash.client.repository.LancamentRepository;
import com.coursedash.client.repository.filter.LacamentFilter;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.coursedash.client.exception.PersonInactiveorNotFoundException;
import com.coursedash.client.model.Lancament;
import com.coursedash.client.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LancamentService {
    
@Autowired
private    LancamentRepository lancamentRepository;

@Autowired
private PersonService personService;

public Page<Lancament> getAllLancament(LacamentFilter lacamentFilter,Pageable pageable){

    return lancamentRepository.filter(lacamentFilter,pageable);
}
public void deleteById(Long id){
	lancamentRepository.deleteById(id);
}

public Lancament save(Lancament lancament) {
	Person person = personService.findById(lancament.getPessoa().getId()).get();
	if(person.isInactive()){
		throw new PersonInactiveorNotFoundException();

	}
	return lancamentRepository.save(lancament);
}

public Lancament getbyId(Long id) throws Exception {
	return  lancamentRepository.findById(id).orElseThrow(()->new Exception("Lancament not found "));
}
    
}
