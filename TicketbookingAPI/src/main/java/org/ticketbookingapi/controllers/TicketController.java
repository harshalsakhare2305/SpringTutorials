package org.ticketbookingapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ticketbookingapi.exceptions.PassengerNotFoundException;
import org.ticketbookingapi.model.Passenger;
import org.ticketbookingapi.model.Ticket;
import org.ticketbookingapi.services.ITicketService;

@RestController
public class TicketController {

    private ITicketService service;

    @Autowired
    public TicketController setService(ITicketService service) {
        this.service = service;
        return this;
    }

    @PostMapping("/register-passenger")
    public ResponseEntity<Passenger> registerPassennger(@RequestBody Passenger passenger){
        Passenger p = service.registerPassenger(passenger);
        return new ResponseEntity<Passenger>(p, HttpStatus.CREATED);
    }

    @PostMapping("/book-ticket/{passengerId}")
    public ResponseEntity<Ticket> bookTicket(@PathVariable("passengerId") Long passengerId) throws PassengerNotFoundException{
       Ticket ticket= service.bookTicket(passengerId);
       return new ResponseEntity<Ticket>(ticket,HttpStatus.CREATED);
    }
}
