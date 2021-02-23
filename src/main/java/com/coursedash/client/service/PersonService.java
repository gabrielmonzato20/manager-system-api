package com.coursedash.client.service;

import java.util.Optional;

import com.coursedash.client.model.Person;
import com.coursedash.client.repository.PersonRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person updateById(Long id , Person person){
        Person personsave = extracted(id);
        BeanUtils.copyProperties(person, personsave,"id");
        personRepository.save(personsave);
        return personsave;
    }

    private Person extracted(Long id) throws UnsupportedOperationException{
        Person personsave = personRepository.findById(id).orElseThrow(
            () -> new EmptyResultDataAccessException(1));
        return personsave;
    }

    public Optional<Person> findById(Long id){ 
        Optional<Person> person = personRepository.findById(id);
        return person;
    }

	public void updateStatus(long id, Boolean active) {
        Person person = extracted(id);
        person.setActive(active);
        personRepository.save(person);
	}
}
