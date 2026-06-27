package org.springboottutorials.controller;


import org.springboottutorials.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String showForm(Model model){

        model.addAttribute("employee",new Employee());
        return "form";
    }

    @PostMapping("/save")
    public String saveEmployee(Model model, @ModelAttribute Employee employee){
        model.addAttribute("emp",employee);
        return "result";
    }
}
