package org.ctobticketbookingapp.service;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ITickerServices implements ITicketServices{

     private String url = "http://localhost:8080/";

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        RestTemplate template =new RestTemplate();
        Passenger p =template.postForEntity(url+"register-passenger",passenger,Passenger.class).getBody();
        return p;
    }

    @Override
    public Ticket bookTicket(Long id) {
        RestTemplate template =new RestTemplate();
        return template.postForEntity(url+"book-ticket/"+id,null, Ticket.class).getBody();
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        RestTemplate template =new RestTemplate();
        return template.getForEntity(url+"get-ticket/"+ticketId,Ticket.class).getBody();
    }

    @Override
    public List<Passenger> getAllPassenger() {
        RestTemplate template =new RestTemplate();
        return template.getForEntity(url+"getallpassengers",List.class).getBody();
    }
}
