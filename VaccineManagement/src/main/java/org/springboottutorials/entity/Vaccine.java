package org.springboottutorials.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vaccine {

    @Id
    private Integer id;

    private String name;

    private String owner;

    private Double price;


    public Vaccine(Integer id, String name, String owner, Double price) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.price = price;
    }


    public Vaccine() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                '}';
    }
}
