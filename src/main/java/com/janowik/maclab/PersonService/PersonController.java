package com.janowik.maclab.PersonService;

import com.janowik.maclab.Model.Person;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    private ResponseEntity<List<Person>> getAllPerson() throws NotFoundException {
        List<Person> listPerson = personService.findAll();
        if (listPerson.isEmpty()){
            throw new NotFoundException("Not found any Person");
        }else {
            return ResponseEntity(listPerson, HttpStatus.OK);
        }
    }
    @PostMapping
    private ResponseEntity savePerson(@Valid Person person){
        Optional<Person> personExist = Optional.ofNullable(personService.findPersonByEmail(person.getEmail()));
        if (personExist.isPresent()){
            throw new EntityExistsException("Person already exist.");
        }else {
            return ResponseEntity.ok().body(personService.savePerson(person));
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
