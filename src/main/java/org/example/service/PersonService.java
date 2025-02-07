package org.example.service;

import org.example.entity.PersonEntity;
import org.example.exception.ResourceNotFoundException;
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

    public PersonEntity updatePerson(Long id, PersonEntity personDetails) {
        // Logic to find the existing person, update its fields, and save it.
        // For example:
        PersonEntity existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        existingPerson.setName(personDetails.getName());
        existingPerson.setAge(personDetails.getAge());
        return personRepository.save(existingPerson);
    }

    public void deletePerson(Long id) {
        // Logic to delete the person.
        PersonEntity person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        personRepository.delete(person);
    }

    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }
}
