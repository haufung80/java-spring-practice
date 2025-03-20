package org.example.controller;

import jakarta.validation.Valid;
import org.example.client.PersonClient;
import org.example.dto.PersonDTO;
import org.example.entity.PersonEntity;
import org.example.service.PersonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonServiceImpl personServiceImpl;

    private final PersonClient personClient;

    public PersonController(PersonServiceImpl personServiceImpl,
                            PersonClient personClient) {
        this.personServiceImpl = personServiceImpl;
        this.personClient = personClient;
    }

    // Endpoint to retrieve all persons
    @GetMapping("/persons")
    public ResponseEntity<List<PersonEntity>> getAllPersons() {
        return ResponseEntity.ok(personServiceImpl.getAllPersons());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable Long id) {
        return ResponseEntity.of(personServiceImpl.getPersonById(id));
    }

    // Endpoint to create a new person
    @PostMapping("/persons")
    public ResponseEntity<PersonEntity> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity(personDTO.name(), personDTO.age());
        return ResponseEntity.ok(personServiceImpl.createPerson(personEntity.getName(), personEntity.getAge()));
    }

    // Endpoint to update an existing person
    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) {
        PersonEntity personDetails = new PersonEntity(personDTO.name(), personDTO.age());
        return ResponseEntity.ok(personServiceImpl.updatePerson(id, personDetails));
    }

    // Endpoint to delete a person by id
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personServiceImpl.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/persons/{id}")
    public ResponseEntity<PersonEntity> getPersonClientById(@PathVariable Long id) {
        return personClient.getPersonById(id);
    }
}
