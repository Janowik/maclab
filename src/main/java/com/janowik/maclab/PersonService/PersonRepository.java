package com.janowik.maclab.PersonService;

import com.janowik.maclab.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByEmail(String email);
    Person findPersonById(Long id);
    Person findPersonByPhoneNumber(String phoneNumber);
}
