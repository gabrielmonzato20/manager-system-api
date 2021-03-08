package com.coursedash.client.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import com.coursedash.client.event.EventCreatead;
import com.coursedash.client.model.Person;
import com.coursedash.client.repository.PersonRepository;
import com.coursedash.client.service.PersonService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilderFactory;


@RestController
@RequestMapping("/persons")
public class PersonResource {
   
    @Autowired
    private PersonRepository personRepository ;
    @Autowired
    private ApplicationEventPublisher event;
    @Autowired
    private PersonService personService ;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') and #oauth2.hasScope('read')")
    public ResponseEntity<?> findAll(){
    List<Person> persons = personRepository.findAll();
    return  new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    

}

@PostMapping
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') and #oauth2.hasScope('read')")
public ResponseEntity<Person> save(@Valid @RequestBody Person person,HttpServletResponse  response){
    Person savedPerson = personRepository.save(person);
   event.publishEvent(new EventCreatead(this, response, person.getId()));
    return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
     

}

@GetMapping("/{id}")
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') and #oauth2.hasScope('read')")
public ResponseEntity<Object> getById(@PathVariable("id") Long id){
    Optional<Person> person = personService.findById(id);
    return person.isPresent() ? ResponseEntity.ok(person):ResponseEntity.notFound().build(); 
}

@DeleteMapping("/{id}")
@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteById(@PathVariable("id") Long id){
    personRepository.deleteById(id);

}
@PutMapping("/{id}")
@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
public ResponseEntity<Person> updateByid(@PathVariable Long id,
@Valid @RequestBody Person person){

    return ResponseEntity.ok(personService.updateById(id,person));


}
@PutMapping("/{id}/active")
@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and  #oauth2.hasScope('write')")
public void setActive(@PathVariable long id , @RequestBody Boolean active){
    personService.updateStatus(id,active);
}
}
