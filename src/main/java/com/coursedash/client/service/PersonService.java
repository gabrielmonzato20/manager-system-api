package com.coursedash.client.service;

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
        Person personsave = personRepository.findById(id).orElseThrow(
            () -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(person, personsave,"id");
        personRepository.save(personsave);
        return personsave;
    }
}
