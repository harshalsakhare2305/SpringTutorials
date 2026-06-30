package org.ticketbookingapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketbookingapi.exceptions.PassengerNotFoundException;
import org.ticketbookingapi.exceptions.TicketNotFoundException;
import org.ticketbookingapi.model.Passenger;
import org.ticketbookingapi.model.Ticket;
import org.ticketbookingapi.services.ITicketService;

import java.util.List;

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

    @GetMapping("/get-ticket/{ticketId}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") Long ticketId) throws TicketNotFoundException {
        Ticket ticket = service.getTicket(ticketId);
        return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
    }

    @GetMapping("/getallpassengers")
    public ResponseEntity<List> getAllPassengers(){
        return new ResponseEntity<List>(service.getAllPassenger(),HttpStatus.OK);
    }
}
