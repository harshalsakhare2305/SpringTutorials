package org.ctobticketbookingapp.model;

public class Ticket {

    private Long ticket_id;

    private String pnr;

    private Double fare;

    public Ticket(Double fare, String pnr) {
        this.fare = fare;
        this.pnr = pnr;
    }

    public Ticket() {
    }

    public Double getFare() {
        return fare;
    }

    public Ticket setFare(Double fare) {
        this.fare = fare;
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
