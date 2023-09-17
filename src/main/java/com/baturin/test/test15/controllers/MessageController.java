package com.baturin.test.test15.controllers;
//CRUD Create (создание), Read (чтение), Update (модификация) и Delete (удаление)
import com.baturin.test.test15.models.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    private Message message;
    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "September 6th","September", LocalDate.of(2003, 9,6)),
            new Message(2, "September 7th","is", LocalDate.of(2003, 9,7)),
            new Message(3, "September 8th","my", LocalDate.of(2003, 9,8)),
            new Message(4, "September 9th","favourite", LocalDate.of(2003, 9,9)),
            new Message(5, "September 10th","time", LocalDate.of(2003, 9,10))
    ));
    //сеттер
    @PostMapping("/message")
    public ResponseEntity<Message> setMessage(@RequestBody Message message) {
       messages.add(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    //геттер
    @GetMapping("/messages")
    public Iterable<Message> getMessages() {
        return messages;
    }
    //добавление
    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }
    //поиск по индекксу
    @GetMapping("/messages/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }
    //обновление по индексу
    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = - 1;
        for (Message p : messages) {
            if (p.getId() == id) {
                index = messages.indexOf(p);
                messages.set(index, message);
            }
        }
        return index == -1 ?  new ResponseEntity<>(addMessage(message), HttpStatus.CREATED) : new ResponseEntity<>(message, HttpStatus.OK);
    }
    //удаление по индексу
    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
    }
}
