package org.example.service;

import org.example.entity.PersonEntity;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    // Constructor injection is a best practice
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonEntity createPerson(String name, int age) {
        PersonEntity person = new PersonEntity(name, age);
        return personRepository.save(person);
    }

    @Override
    public PersonEntity updatePerson(Long id, PersonEntity personDetails) {
        // Logic to find the existing person, update its fields, and save it.
        PersonEntity existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        existingPerson.setName(personDetails.getName());
        existingPerson.setAge(personDetails.getAge());
        return personRepository.save(existingPerson);
    }

    @Override
    public void deletePerson(Long id) {
        // Logic to delete the person.
        PersonEntity person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        personRepository.delete(person);
    }

    @Override
    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<PersonEntity> getPersonById(Long id) {
        return personRepository.findById(id);
    }
}
