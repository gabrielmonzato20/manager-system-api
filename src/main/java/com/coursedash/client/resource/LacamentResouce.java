package com.coursedash.client.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.coursedash.client.event.EventCreatead;
import com.coursedash.client.exception.PersonInactiveorNotFoundException;
import com.coursedash.client.exceptionHandler.MoneyExceptionHandler.Error;
import com.coursedash.client.model.Lancament;
import com.coursedash.client.repository.filter.LacamentFilter;
import com.coursedash.client.repository.projection.ResumeLancament;
import com.coursedash.client.service.LancamentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lancaments")
public class LacamentResouce {

@Autowired
private  LancamentService lancamentService;
@Autowired
private ApplicationEventPublisher event;
@Autowired
private MessageSource messageSource;

@GetMapping
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
public Page<Lancament>getLacament(LacamentFilter lacamentFilter,Pageable pageable){
    return lancamentService.getAllLancament(lacamentFilter,pageable);
}

@GetMapping(params = "resume")
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
public Page<ResumeLancament>getLacamentResume(LacamentFilter lacamentFilter,Pageable pageable){
    return lancamentService.getAllLancamentResume(lacamentFilter,pageable);
}
@PostMapping
@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and #oauth2.hasScope('write')")
public ResponseEntity<Lancament> createLacament(@Valid @RequestBody Lancament lancament, HttpServletResponse response){
    Lancament lancamentSave = lancamentService.save(lancament);
    
    event.publishEvent(new EventCreatead(this, response, lancamentSave.getCodigo()));
    return ResponseEntity.ok(lancamentSave);

}
@GetMapping("/{id}")
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
public ResponseEntity<Lancament> getById(@PathVariable Long id) throws Exception {
    return ResponseEntity.ok( lancamentService.getbyId(id));
}
@DeleteMapping("/{id}")
@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and #oauth2.hasScope('write')")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteById(@PathVariable Long id){
    lancamentService.deleteById(id);
}

@ExceptionHandler({PersonInactiveorNotFoundException.class})
public ResponseEntity<Object> handlePersonInactiveorNotFoundException(
    PersonInactiveorNotFoundException ex
)
{
    String msgUser = messageSource.getMessage(
        "mensagem.person.inactive", 
        null,
        LocaleContextHolder.getLocale());
    String msgDev = Optional.ofNullable(ex.getCause()).orElse(ex).toString();
    List<Error> errors = Arrays.asList(new Error(msgUser,msgDev));
    return ResponseEntity.badRequest().body(errors);
}

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and #oauth2.hasScope('write')")
    public ResponseEntity<Lancament> updateLacament(@Valid @RequestBody Lancament lancament, HttpServletResponse response){
        Lancament lancamentSave = lancamentService.save(lancament);

        event.publishEvent(new EventCreatead(this, response, lancamentSave.getCodigo()));
        return ResponseEntity.ok(lancamentSave);
    }
}
