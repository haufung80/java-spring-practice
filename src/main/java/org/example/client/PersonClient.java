package org.example.client;

import org.example.entity.PersonEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "person-service", url = "http://localhost:8080", path = "/persons")
public interface PersonClient {

    @GetMapping("/{id}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable("id") long id);

}