package org.ctobticketbookingapp.model;

import java.time.LocalDate;

public class Passenger {

    private Long id;
    private String name;

    private LocalDate dateofJourney;

    private String boarding ;

    private String destination;

    private Integer age;


    public Passenger(String name, LocalDate dateofJourney, String boarding, String destination, Integer age) {
        this.name = name;
        this.dateofJourney = dateofJourney;
        this.boarding = boarding;
        this.destination = destination;
        this.age = age;
    }

    public Passenger() {
    }

    public Long getId() {
        return id;
    }

    public Passenger setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dateofJourney=" + dateofJourney +
                ", boarding='" + boarding + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public Passenger setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getBoarding() {
        return boarding;
    }

    public Passenger setBoarding(String boarding) {
        this.boarding = boarding;
        return this;
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateofJourney() {
        return dateofJourney;
    }

    public Passenger setDateofJourney(LocalDate dateofJourney) {
        this.dateofJourney = dateofJourney;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Passenger setDestination(String destination) {
        this.destination = destination;
        return this;
    }
}
