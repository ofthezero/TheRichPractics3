package com.example.Test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name, surname, petronymic;

    Integer snils_number , oms_number;

    public Passport(String name, String surname, String petronymic, Integer snils_number, Integer oms_number) {
        this.name = name;
        this.surname = surname;
        this.petronymic = petronymic;
        this.snils_number = snils_number;
        this.oms_number = oms_number;
    }

    public Passport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPetronymic() {
        return petronymic;
    }

    public void setPetronymic(String petronymic) {
        this.petronymic = petronymic;
    }

    public Integer getSnils_number() {
        return snils_number;
    }

    public void setSnils_number(Integer snils_number) {
        this.snils_number = snils_number;
    }

    public Integer getOms_number() {
        return oms_number;
    }

    public void setOms_number(Integer oms_number) {
        this.oms_number = oms_number;
    }
}
