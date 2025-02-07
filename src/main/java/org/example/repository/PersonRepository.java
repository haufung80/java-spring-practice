package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    // Additional query methods (if needed) can be defined here.
}