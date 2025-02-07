package org.example.controller;

import org.example.entity.PersonEntity;
import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Endpoint to update an existing person
    @PutMapping("/persons/{id}")
    public PersonEntity updatePerson(@PathVariable Long id, @RequestBody PersonEntity personDetails) {
        return personService.updatePerson(id, personDetails);
    }

    // Endpoint to delete a person by id
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
