package com.coursedash.client.repository;

import com.coursedash.client.model.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

     Page<Person> findByNameContaining(String name, Pageable page);
}
