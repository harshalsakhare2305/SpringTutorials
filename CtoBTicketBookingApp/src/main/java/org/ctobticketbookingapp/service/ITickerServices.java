package org.ctobticketbookingapp.service;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.TIcket;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ITickerServices implements ITicketServices{

     private String registerurl = "http://localhost:8080/register-passenger";

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        RestTemplate template =new RestTemplate();
        Passenger p =template.postForEntity(registerurl,Passenger.class,);
    }

    @Override
    public TIcket bookTicket(Long id) {
        return null;
    }

    @Override
    public TIcket getTicket(Long ticketId) {
        return null;
    }

    @Override
    public List<Passenger> getAllPassenger() {
        return List.of();
    }
}
