package org.ticketbookingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate dateofJourney;

    private String boarding ;

    private String destination;

    private Integer age;

    @OneToOne(mappedBy = "passenger",cascade =CascadeType.ALL)
    @JsonIgnore
    private Ticket ticket;


    public Passenger(Long id, String name, LocalDate dateofJourney, String boarding, String destination, Integer age, Ticket ticket) {
        this.id = id;
        this.name = name;
        this.dateofJourney = dateofJourney;
        this.boarding = boarding;
        this.destination = destination;
        this.age = age;
        this.ticket = ticket;
    }

    public Passenger() {
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", dateofJourney=" + dateofJourney +
                ", boarding='" + boarding + '\'' +
                ", destination='" + destination + '\'' +
                ", ticket=" + ticket +
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

    public Long getId() {
        return id;
    }

    public Passenger setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Passenger setTicket(Ticket ticket) {
        this.ticket = ticket;
        return this;
    }
}
