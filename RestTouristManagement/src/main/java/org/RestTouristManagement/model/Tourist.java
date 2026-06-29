package org.RestTouristManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;

    private String last_name;

    private String destination;

    private String packagetype;

    private Long budget;


    public Tourist(Long id, String first_name, String last_name, String destination, String packagetype, Long budget) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.destination = destination;
        this.packagetype = packagetype;
        this.budget = budget;
    }

    public Tourist() {
    }


    public Long budget() {
        return budget;
    }

    public Long getBudget() {
        return budget;
    }

    public Tourist setBudget(Long budget) {
        this.budget = budget;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Tourist setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Tourist setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Tourist setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Tourist setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public Tourist setPackagetype(String packagetype) {
        this.packagetype = packagetype;
        return this;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "budget=" + budget +
                ", id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", destination='" + destination + '\'' +
                ", packagetype='" + packagetype + '\'' +
                '}';
    }
}
