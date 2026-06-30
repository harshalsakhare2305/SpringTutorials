package org.ticketbookingapi.services;

import org.ticketbookingapi.model.Passenger;
import org.ticketbookingapi.model.Ticket;

public interface ITicketService {

    public Passenger registerPassenger(Passenger passenger);

    public Ticket bookTicket(Long id);

    public  Ticket getTicket(Long ticketId);
}
