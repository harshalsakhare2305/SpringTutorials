package org.ticketbookingapi.services;

import org.ticketbookingapi.exceptions.PassengerNotFoundException;
import org.ticketbookingapi.exceptions.TicketNotFoundException;
import org.ticketbookingapi.model.Passenger;
import org.ticketbookingapi.model.Ticket;

import java.util.List;

public interface ITicketService {

    public Passenger registerPassenger(Passenger passenger);

    public Ticket bookTicket(Long id) throws PassengerNotFoundException;

    public  Ticket getTicket(Long ticketId) throws TicketNotFoundException;

    public List<Passenger> getAllPassenger();
}
