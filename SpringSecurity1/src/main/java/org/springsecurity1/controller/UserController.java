package org.springsecurity1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springsecurity1.model.User;
import org.springsecurity1.repo.IUserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/register-user")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User u = service.registeruser(user);
        return new ResponseEntity<User>(u, HttpStatus.CREATED);
    }

    @GetMapping("/all-users")
    public ResponseEntity<List> getAllUsers(){
        return new ResponseEntity<List>(service.getAllusers(),HttpStatus.OK);
    }
}
