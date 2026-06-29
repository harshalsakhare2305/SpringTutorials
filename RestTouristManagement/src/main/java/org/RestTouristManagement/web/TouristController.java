package org.RestTouristManagement.web;


import org.RestTouristManagement.model.Tourist;
import org.RestTouristManagement.services.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TouristController {

    private ITouristService service;

    @Autowired
    public TouristController setService(ITouristService service) {
        this.service = service;
        return this;
    }

    @GetMapping("/touristinfo")
    public ResponseEntity<List> getAllTouristDetails(){
        List<Tourist> touristList = service.findAllTourist();

        return new ResponseEntity<List>(touristList,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
        String msg = service.registerTourist(tourist);

        return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    }


}
