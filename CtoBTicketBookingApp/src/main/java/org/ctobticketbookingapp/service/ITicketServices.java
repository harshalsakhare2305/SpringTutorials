package org.ctobticketbookingapp.service;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.Ticket;

import java.util.List;

public interface ITicketServices {

    public Passenger registerPassenger(Passenger passenger);

    public Ticket bookTicket(Long id) ;

    public Ticket getTicket(Long ticketId);

    public List<Passenger> getAllPassenger();
}
