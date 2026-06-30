package org.ctobticketbookingapp.web;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.Ticket;
import org.ctobticketbookingapp.service.ITicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class B2CTicketController {

    private ITicketServices services;

    @Autowired
    public B2CTicketController setServices(ITicketServices services) {
        this.services = services;
        return this;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/book-ticket-page")
    public String bookTicketPage() {
        return "book-ticket";
    }

    @PostMapping("/register")
    public String registerPassenger(@ModelAttribute Passenger passenger, Model model){
        Passenger pass = services.registerPassenger(passenger);
        model.addAttribute("passenger",pass);
        return "redirect:/home";
    }

    @GetMapping("/book-ticket/{passengerId}")
    public String showTicket(@PathVariable ("passengerId") Long passengerId){
        return "showticket";
    }



    @PostMapping("/book-ticket")
    public String bookTicket(@RequestParam Long passengerId, Model model) {

        Ticket ticket = services.bookTicket(passengerId);

        model.addAttribute("ticket", ticket);

        return "showticket";
    }



    @GetMapping("/get-ticket-page")
    public String getTicketPage(){
        return "get-ticket";
    }

    @GetMapping("/get-ticket/{ticketId}")
    public String getTicket(@PathVariable("ticketId") Long ticketId,Model model){
        Ticket ticket = services.getTicket(ticketId);
        model.addAttribute("ticket",ticket);
        return "showticket";
    }

    @GetMapping("/getAllpassengers")
    public String getAllPassenger(Model model){
        List<Passenger> list = services.getAllPassenger();
        model.addAttribute("passengers",list);
        return "showallpassenger";
    }

    @GetMapping("/register-passenger")
    public String showform(Model model){
        model.addAttribute("emptypassenger",new Passenger());
        return "register-form";
    }


}
