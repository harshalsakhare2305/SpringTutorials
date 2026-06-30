package org.ticketbookingapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.ticketbookingapi.exceptions.PassengerNotFoundException;
import org.ticketbookingapi.exceptions.TicketNotFoundException;
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
    public Ticket bookTicket(Long id) throws PassengerNotFoundException {

        Optional<Passenger> option = passengerRepo.findById(id);

        if(option.isPresent()){
            Passenger passenger = option.get();

            Ticket ticket =new Ticket();
            ticket.setPassenger(passenger);
            ticket.setFare(780.50);
            ticket.setPnr("788512");

            return ticketRepo.save(ticket);
        }else{
          throw new PassengerNotFoundException("Passenger with id"+ id+" Not Found");
        }
    }

    @Override
    public Ticket getTicket(Long ticketId) throws TicketNotFoundException {
        Optional<Ticket> option = ticketRepo.findById(ticketId);

        if(option.isPresent()){
            return option.get();
        }else{
            throw new TicketNotFoundException("Ticket With Id : "+ ticketId+ " Doesn't Exists");
        }
    }
}
