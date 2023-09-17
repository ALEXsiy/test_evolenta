package com.baturin.test.test15.repository;

import com.baturin.test.test15.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}

/*
#Путь к БД
        spring.datasource.url=jdbc:h2:file:./testdb
        #Включить консоль СУБД
        spring.h2.console.enabled=true

        #Настройки Hibernate
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        #Стратегия управления БД
        spring.jpa.hibernate.ddl-auto=update
*/
