package ru.alex.spring.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Student {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 characters")
    private String surname;

    @NotEmpty(message = "Middle name should not be empty")
    @Size(min = 2, max = 30, message = "Middle name should be between 2 and 30 characters")
    private String middleName;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Past
    private Date date;

    private int gr;

    @Min(1)
    private int id;

    public Student() {
    }

    public Student(String name, String surname, String middleName, Date date, int gr, int id) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.date = date;
        this.gr = gr;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGr() {
        return gr;
    }

    public void setGr(int gr) {
        this.gr = gr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
