package org.ctobticketbookingapp.service;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.TIcket;

import java.util.List;

public interface ITicketServices {

    public Passenger registerPassenger(Passenger passenger);

    public TIcket bookTicket(Long id) ;

    public  TIcket getTicket(Long ticketId);

    public List<Passenger> getAllPassenger();
}
