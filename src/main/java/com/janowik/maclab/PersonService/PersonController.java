package com.janowik.maclab.PersonService;

import com.janowik.maclab.Model.Person;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import sun.dc.path.PathError;

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
    private ResponseEntity<Person> getAllPerson() throws NotFoundException {
        List<Person> listPerson = personService.findAll();
        if (listPerson.isEmpty()){
            throw new NotFoundException("Not found any Person");
        }else {
            return new ResponseEntity(listPerson, HttpStatus.OK);
        }
    }
/*
    @PostMapping
    private ResponseEntity savePerson(@Valid Person person){
        Optional<Person> personExist = Optional.ofNullable(personService.findPersonByEmail(person.getEmail()));
        personExist.orElseTh row().
        if (personExist.isPresent()){
            throw new EntityExistsException("Person already exist.");
        }else {
            return Optional.ofNullable(personService.findPersonByEmail(person.getEmail()))
                    .map(ResponseEntity::new)
                    .map()
                    .orElse()
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
*/

    @PutMapping("/{id}")
    private ResponseEntity updatePerson(@PathVariable("{id}") Long id, @Valid Person person) throws NotFoundException {
        Optional<Person> personWithUpdateId = Optional.ofNullable(personService.findPersonById(id));
        if (!personWithUpdateId.isPresent()) {
            throw new NotFoundException("Not found person with id: " + id);
        }else {
            Person updatePerson = Person.builder()
                    .id(id)
                    .name(person.getName())
                    .lastName(person.getLastName())
                    .phoneNumber(person.getPhoneNumber())
                    .email(person.getEmail())
                    .build();
            personService.savePerson(updatePerson);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
