package org.springboottutorials.controllers;


import org.springboottutorials.model.Customer;
import org.springboottutorials.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    private ICustomerService service;

    @Autowired
    public void setService(ICustomerService service) {
        this.service = service;
    }

    @GetMapping("/ctxinfo")
    public String getAllCustomerInfo(Model model){
        List<Customer> customers = service.getAllCustomerList();
        model.addAttribute("customers",customers);
        return "customerInfo";
    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("emptyCustomer",new Customer());
        return "form";
    }









}
