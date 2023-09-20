package com.baturin.test.test15.service;

import com.baturin.test.test15.models.Message;
import com.baturin.test.test15.models.Person;
import com.baturin.test.test15.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Iterable<Person> getPersons() {
        return repository.findAll();
    }
    public Optional<Person> findPersonById(int id) {
        return repository.findById(id);
    }
    public Person addPerson(Person person) {
        repository.save(person);
        return person;
    }
    public ResponseEntity<Person> updatePerson( int id,  Person person) {
        if(repository.existsById(id)) {
            person.setId(id); // сохраняем существующий id
            return new ResponseEntity(repository.save(person), HttpStatus.OK);
        } else {
            return new ResponseEntity(repository.save(person), HttpStatus.CREATED);
        }
    }
    public void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Person> addMessageToPerson(int person_id, Message message) {
        Optional<Person> optional_person = repository.findById(person_id);
        if (optional_person.isPresent()) {
            Person person = optional_person.get();
            message.setPerson(person);
            message.setTime(LocalDateTime.now());
            person.addMessage(message);
            repository.save(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Void> deleteMessageFromPerson(int person_id, int message_id) {
        Optional<Person> optional_person = repository.findById(person_id);
        if (optional_person.isPresent()) {
            Person person = optional_person.get();
            person.deleteMessage(message_id);
            repository.save(person);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Message>> getMessagesFromPersonId(int person_id) {
        Optional<Person> optional_person = repository.findById(person_id);
        if (optional_person.isPresent()) {
            Person person = optional_person.get();
            return new ResponseEntity<>(person.getMessages(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}