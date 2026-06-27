package org.springboottutorials.controllers;


import org.springboottutorials.entity.User;
import org.springboottutorials.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryParameterController {


    private IService service;

    @Autowired
    public void setService(IService service) {
        this.service = service;
    }

    @GetMapping("/profile")
    public String getdetails(Model model){
        System.out.println("Inside Query Controller");
         User user =new User("Harshal",22,"Mumbai");
       // model.addAttribute("msg","Good Morning Harshal , Welcome to Our New SpringBoot Course");
        model.addAttribute("Profile",user);
        return "profile";
    }

    // This is the path parameter
    @GetMapping("/profile/{name}")
    public String getCustomGreetings(@PathVariable("name") String name, Model model){
        System.out.println("Inside Query Controller");
       // User user =new User(name,22,"Mumbai");
         model.addAttribute("msg","Good Morning "+name +" , Welcome to Our New SpringBoot Course");
       // model.addAttribute("Profile",user);
        return "customProfile";
    }

    @GetMapping("/greetings")
    public String getPathParameterGreeting(String name,Model model){
        model.addAttribute("msg","Good Morning "+name +" , Welcome to Our New SpringBoot Course");
        return "customProfile";
    }

    @GetMapping("/greetings1")
    public String getPathParameterGreeting1(@RequestParam("name") String name, @RequestParam("course") String course, Model model){
        model.addAttribute("msg","Good Morning "+name +" , Welcome to Our New  "+ course +"Course");
        return "customProfile";
    }

     @GetMapping("/greetingtime")
    public String getProperGreetingforUserBasedonQuery(@RequestParam("name") String name,@RequestParam("course") String course,Model model){
       String greet = service.getProperGreeting();
        model.addAttribute("msg",greet +" "+name +" , Welcome to Our New  "+ course +"Course");
        return "customProfile";
    }
}
