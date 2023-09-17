package com.baturin.test.test15.models;

import java.time.LocalDate;

public class Message {
    //поля
    private int id;
    private String title;
    private String text;
    private LocalDate time;

    //конструкторы
    public Message() {
    }
    public Message(int id, String title, String text, LocalDate time) {
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

    public LocalDate getTime() {
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

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
