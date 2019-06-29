package com.janowik.maclab.PersonService;

import com.janowik.maclab.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImplementation implements PersonService {

    private final
    PersonRepository personRepository;

    @Autowired
    public PersonServiceImplementation(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(Person person) {
        Person createPerson = Person.builder()
                .name(person.getName())
                .lastName(person.getLastName())
                .phoneNumber(person.getPhoneNumber())
                .email(person.getEmail())
                .build();
        personRepository.save(createPerson);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.deleteById(person.getId());
    }
}
