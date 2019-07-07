package com.janowik.maclab.PersonService;

import com.janowik.maclab.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public void updatePerson(Long id, Person person) {
        Person updateOldPerson = Person.builder()
                .id(id)
                .name(person.getName())
                .lastName(person.getLastName())
                .phoneNumber(person.getPhoneNumber())
                .email(person.getEmail())
                .build();
        personRepository.save(updateOldPerson);
    }

    @Override
    public Person findPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email);
    }

    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {
        return personRepository.findPersonByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
