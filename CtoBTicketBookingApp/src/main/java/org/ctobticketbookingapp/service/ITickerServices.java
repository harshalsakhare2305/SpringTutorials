package org.ctobticketbookingapp.service;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
public class ITickerServices implements ITicketServices{

     private String url = "http://localhost:8080/";

     private WebClient client;

     @Autowired
    public ITickerServices setClient(WebClient client) {
        this.client = client;
        return this;
    }

    @Override
    public Passenger registerPassenger(Passenger passenger) {
//        RestTemplate template =new RestTemplate();
//        Passenger p =template.postForEntity(url+"register-passenger",passenger,Passenger.class).getBody();
//        return p;

        Passenger p = client.post().uri("register-passenger").bodyValue(passenger).retrieve().bodyToMono(Passenger.class).block();
        return p;
    }

    @Override
    public Ticket bookTicket(Long id) {
//        RestTemplate template =new RestTemplate();
//        return template.postForEntity(url+"book-ticket/"+id,null, Ticket.class).getBody();

        return client.post().uri("book-ticket/"+id).retrieve().bodyToMono(Ticket.class).block();
    }

    @Override
    public Ticket getTicket(Long ticketId) {
//        RestTemplate template =new RestTemplate();
//        return template.getForEntity(url+"get-ticket/"+ticketId,Ticket.class).getBody();

        return client.get().uri("get-ticket/"+ticketId).retrieve().bodyToMono(Ticket.class).block();
    }

    @Override
    public List<Passenger> getAllPassenger() {
//        RestTemplate template =new RestTemplate();
//        return template.getForEntity(url+"getallpassengers",List.class).getBody();

        return client.get().uri("getallpassengers").retrieve().bodyToFlux(List.class).blockFirst();
    }
}
