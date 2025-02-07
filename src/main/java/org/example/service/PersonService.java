package org.example.service;

import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    // Constructor injection is a best practice
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity createPerson(String name, int age) {
        PersonEntity person = new PersonEntity(name, age);
        return personRepository.save(person);
    }

    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }
}
