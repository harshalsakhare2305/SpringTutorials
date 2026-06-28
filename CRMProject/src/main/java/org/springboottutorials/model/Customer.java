package org.springboottutorials.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long C_id;

    private String first_name;

    private String last_name;

    private String email;

    private String city;


    public Customer(String first_name, String last_name, String email, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.city = city;
    }

    public Customer() {
    }


    public Long getC_id(){
        return C_id;
    }


    public String getCity() {
        return city;
    }

    public Customer setCity(String city) {
        this.city = city;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Customer setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Customer setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }
}
