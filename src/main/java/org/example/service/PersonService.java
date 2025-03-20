package org.example.service;

import org.example.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    PersonEntity createPerson(String name, int age);

    PersonEntity updatePerson(Long id, PersonEntity personDetails);

    void deletePerson(Long id);

    List<PersonEntity> getAllPersons();

    Optional<PersonEntity> getPersonById(Long id);
}
