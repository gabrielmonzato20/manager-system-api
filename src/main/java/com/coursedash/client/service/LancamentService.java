package com.coursedash.client.service;

import com.coursedash.client.repository.Lancamentrepository;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.coursedash.client.model.Lancament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LancamentService {
    
@Autowired
private    Lancamentrepository lancamentRepository;    

public List<Lancament> getAllLancament(){

    return lancamentRepository.findAll();
}

public Lancament save(Lancament lancament) {
	return lancamentRepository.save(lancament);
}

public Lancament getbyId(Long id) throws Exception {
	return  lancamentRepository.findById(id).orElseThrow(()->new Exception("Lancament not found "));
}
    
}
