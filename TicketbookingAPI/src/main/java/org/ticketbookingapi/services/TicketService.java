package org.ticketbookingapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.ticketbookingapi.model.Passenger;
import org.ticketbookingapi.model.Ticket;
import org.ticketbookingapi.repo.IPassengerRepo;
import org.ticketbookingapi.repo.ITicketRepo;

import java.util.Optional;

public class TicketService implements ITicketService{

    private IPassengerRepo passengerRepo;

    private ITicketRepo ticketRepo;

    @Autowired
    public TicketService setPassengerRepo(IPassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
        return this;
    }

    @Autowired
    public TicketService setTicketRepo(ITicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
        return this;
    }

    @Override
    public Passenger registerPassenger(Passenger passenger) {
         return passengerRepo.save(passenger);
    }

    @Override
    public Ticket bookTicket(Long id) {

        Optional<Passenger> option = passengerRepo.findById(id);

        if(option.isPresent()){

        }else{

        }
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        return null;
    }
}
