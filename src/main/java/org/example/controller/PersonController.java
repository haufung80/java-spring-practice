package org.example.controller;

import org.example.entity.PersonEntity;
import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Endpoint to retrieve all persons
    @GetMapping("/persons")
    public List<PersonEntity> getAllPersons() {
        return personService.getAllPersons();
    }

    // Endpoint to create a new person
    @PostMapping("/persons")
    public PersonEntity createPerson(@RequestBody PersonEntity personEntity) {
        return personService.createPerson(personEntity.getName(), personEntity.getAge());
    }
}
