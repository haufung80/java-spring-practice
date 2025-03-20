package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.PersonDTO;
import org.example.entity.PersonEntity;
import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Endpoint to retrieve all persons
    @GetMapping("/persons")
    public ResponseEntity<List<PersonEntity>> getAllPersons() {
        return ResponseEntity.of(Optional.ofNullable(personService.getAllPersons()));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable Long id) {
        return ResponseEntity.of(personService.getPersonById(id));
    }

    // Endpoint to create a new person
    @PostMapping("/persons")
    public ResponseEntity<PersonEntity> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity(personDTO.name(), personDTO.age());
        return ResponseEntity.of(Optional.ofNullable(personService.createPerson(personEntity.getName(), personEntity.getAge())));
    }

    // Endpoint to update an existing person
    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) {
        PersonEntity personDetails = new PersonEntity(personDTO.name(), personDTO.age());
        return ResponseEntity.of(Optional.ofNullable(personService.updatePerson(id, personDetails)));
    }

    // Endpoint to delete a person by id
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
