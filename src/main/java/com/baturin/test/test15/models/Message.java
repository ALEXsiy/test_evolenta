package com.baturin.test.test15.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Message {
    //поля
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String text;
    private LocalDateTime time;
    @ManyToOne
    @JsonIgnore
    private Person person;
    //конструкторы
    public Message() {
    }
    public Message( String title, String text, LocalDateTime time) {
        this.title=title;
        this.text=text;
        this.time=time;
    }
    public Message(int id, String title, String text, LocalDateTime time) {
        this.id = id;
        this.title=title;
        this.text=text;
        this.time=time;
    }

    //геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
