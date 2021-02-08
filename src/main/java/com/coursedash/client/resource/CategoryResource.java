package com.coursedash.client.resource;

import com.coursedash.client.event.EventCreatead;
import com.coursedash.client.model.Category;
import com.coursedash.client.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/categorys")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher event;
    
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Category> categorys = categoryRepository.findAll();
        return ResponseEntity.ok(categorys);
        //return  !categorys.isEmpty()?    ResponseEntity.ok(categorys):ResponseEntity.noContent().build();
    }
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> save(@Valid @RequestBody Category category,HttpServletResponse response){
        Category categorySave = categoryRepository.save(category);
        event.publishEvent(new EventCreatead(this, response, category.getId()));
        return     ResponseEntity.status(HttpStatus.CREATED).body(categorySave);
}
@GetMapping("/{id}")
ResponseEntity<Category> findByid(@PathVariable Long id){
    Optional<Category> category = categoryRepository.findById(id);
    return category.isPresent() ? ResponseEntity.ok(category.get()) :  ResponseEntity.notFound().build();
}
}
