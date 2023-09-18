package com.baturin.test.test15.repository;

import com.baturin.test.test15.models.Message;
import com.baturin.test.test15.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
}