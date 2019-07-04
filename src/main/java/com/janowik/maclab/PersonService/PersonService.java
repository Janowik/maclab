package com.janowik.maclab.PersonService;

import com.janowik.maclab.Model.Person;
import org.springframework.stereotype.Service;

@Service("personService")
public interface PersonService {
    void savePerson(Person person);
    void updatePerson(Long id, Person person);
    Person findPersonByEmail(String email);
    Person findPersonByPhoneNumber(String phoneNumber);
}
