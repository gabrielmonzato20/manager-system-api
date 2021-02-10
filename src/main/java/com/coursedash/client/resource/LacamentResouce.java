package com.coursedash.client.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.coursedash.client.event.EventCreatead;
import com.coursedash.client.model.Lancament;
import com.coursedash.client.repository.Lancamentrepository;
import com.coursedash.client.service.LancamentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancaments")
public class LacamentResouce {

@Autowired
private  LancamentService lancamentService;
@Autowired
private ApplicationEventPublisher event;


@GetMapping
public Iterable<Lancament>getLacament(){
    return lancamentService.getAllLancament();
}

@PostMapping
public ResponseEntity<Lancament> createLacament(@Valid @RequestBody Lancament lancament, HttpServletResponse response){
    Lancament lancamentSave = lancamentService.save(lancament);
    
    event.publishEvent(new EventCreatead(this, response, lancamentSave.getCodigo()));
    return ResponseEntity.ok(lancamentSave);

}
@GetMapping("/{id}")
public ResponseEntity<Lancament> getById(@PathVariable Long id) throws Exception {
    return ResponseEntity.ok( lancamentService.getbyId(id));
}
}
