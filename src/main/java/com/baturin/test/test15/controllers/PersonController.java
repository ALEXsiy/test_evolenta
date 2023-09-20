package com.baturin.test.test15.controllers;

import java.lang.*;

import com.baturin.test.test15.models.Message;
import com.baturin.test.test15.repository.PersonRepository;
import com.baturin.test.test15.models.Person;
import com.baturin.test.test15.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonService service;

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return service.getPersons();
    }
    @GetMapping("/persons/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return service.findPersonById(id);
    }
    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }
    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return service.updatePerson(id, person);
    }
    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable int id) {
        service.deletePerson(id);
    }

    @PostMapping("/persons/{id}/messages")
    public ResponseEntity<Person> addMessage(@PathVariable int id, @RequestBody Message message) {
        return service.addMessageToPerson(id, message);
    }

    @DeleteMapping("/persons/{personId}/messages/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int personId, @PathVariable int messageId) {
        return service.deleteMessageFromPerson(personId, messageId);
    }

    @GetMapping("/persons/{id}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable int id) {
        return service.getMessagesFromPersonId(id);
    }
}