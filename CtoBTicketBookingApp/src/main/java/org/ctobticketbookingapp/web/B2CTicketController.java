package org.ctobticketbookingapp.web;

import org.ctobticketbookingapp.model.Passenger;
import org.ctobticketbookingapp.model.Ticket;
import org.ctobticketbookingapp.service.ITicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class B2CTicketController {

    private ITicketServices services;

    @Autowired
    public B2CTicketController setServices(ITicketServices services) {
        this.services = services;
        return this;
    }

    @PostMapping("/register")
    public String registerPassenger(@ModelAttribute Passenger passenger, Model model){
        Passenger pass = services.registerPassenger(passenger);
        model.addAttribute("passenger",pass);
        return "redirect:/home";
    }

    @PostMapping("/book-ticket/{passengerId}")
    public String bookTicket(@PathVariable ("passengerId") Long passengerId, Model model){
        Ticket ticket=services.bookTicket(passengerId);
        model.addAttribute("ticket/"+passengerId,ticket);
        return "showticket";
    }

    @GetMapping("/get-ticket/{ticketId}")
    public String getTicket(@PathVariable("ticketId") Long ticketId,Model model){
        Ticket ticket = services.getTicket(ticketId);
        model.addAttribute("ticket/"+ticketId,ticket);
        return "showticket";
    }

    @GetMapping("/getAllpassengers")
    public String getAllPassenger(Model model){
        List<Passenger> list = services.getAllPassenger();
        model.addAttribute("allpassenger",list);
        return "showallpassenger";
    }

    @GetMapping("/register-passenger")
    public String showform(Model model){
        model.addAttribute("emptypassenger",new Passenger());
        return "register-form";
    }


}
