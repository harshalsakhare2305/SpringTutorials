package org.springboottutorials.controllers;


import org.springboottutorials.model.Customer;
import org.springboottutorials.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer,Model model){
        service.RegisternewCustomer(customer);
        return "redirect:/ctxinfo";
    }

     @GetMapping("/update/{id}")
    public String updateCustomerDetails(@PathVariable Long id,Model model){
          Customer customer = service.getCustomerByid(id);
          model.addAttribute("customer",customer);
          return "updateform";
     }

     @PostMapping("/update/{id}")
     public String UpdateCustomeRecord(@PathVariable Long id,@ModelAttribute Customer customer,Model model){
           service.UpdateCustomerRecord(customer);
         System.out.println("ID = " + customer.getC_id());
           model.addAttribute("updatedCustomer",customer);
           return "redirect:/ctxinfo";
     }









}
