package org.ticketbookingapi.model;

import jakarta.persistence.*;



@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;

    private String pnr;

    private Double fare;

    @OneToOne
    @JoinColumn(name = "passenger_id")
    private  Passenger passenger;


    public Ticket(Long ticket_id, String pnr, Double fare, Passenger passenger) {
        this.ticket_id = ticket_id;
        this.pnr = pnr;
        this.fare = fare;
        this.passenger = passenger;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "fare=" + fare +
                ", ticket_id=" + ticket_id +
                ", pnr='" + pnr + '\'' +
                ", passenger=" + passenger +
                '}';
    }

    public Double getFare() {
        return fare;
    }

    public Ticket setFare(Double fare) {
        this.fare = fare;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Ticket setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public String getPnr() {
        return pnr;
    }

    public Ticket setPnr(String pnr) {
        this.pnr = pnr;
        return this;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public Ticket setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
        return this;
    }
}
