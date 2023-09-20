package com.baturin.test.test16.controllers;
//CRUD Create (создание), Read (чтение), Update (модификация) и Delete (удаление)
import com.baturin.test.test16.models.Message;
import com.baturin.test.test16.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @GetMapping("/messages")
    public Iterable<Message> getMessages() {
        return repository.findAll();
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        repository.save(message);
        return message;
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        if(repository.existsById(id)) {
            message.setId(id); // сохраняем существующий id
            return new ResponseEntity(repository.save(message), HttpStatus.OK);
        } else {
            return new ResponseEntity(repository.save(message), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable int id) {
        repository.deleteById(id);
    }
}
