package org.springboottutorials.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class FirstController {

    @RequestMapping("/welcome")
    public ModelAndView getMessage() {

        System.out.println("Inside Controller");

        ModelAndView mvc = new ModelAndView("index");
        mvc.addObject("message", "Welcome to Our First Project");
        return mvc;
    }
}
