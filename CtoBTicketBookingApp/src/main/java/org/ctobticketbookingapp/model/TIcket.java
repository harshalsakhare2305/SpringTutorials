package org.ctobticketbookingapp.model;

public class TIcket {

    private Long ticket_id;

    private String pnr;

    private Double fare;

    public TIcket(Double fare, String pnr) {
        this.fare = fare;
        this.pnr = pnr;
    }

    public TIcket() {
    }

    public Double getFare() {
        return fare;
    }

    public TIcket setFare(Double fare) {
        this.fare = fare;
        return this;
    }

    public String getPnr() {
        return pnr;
    }

    public TIcket setPnr(String pnr) {
        this.pnr = pnr;
        return this;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public TIcket setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
        return this;
    }
}
