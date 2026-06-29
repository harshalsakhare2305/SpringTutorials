package org.RestTouristManagement.web;


import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.Tourist;
import org.RestTouristManagement.services.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tourist/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable("id") Long id){

        try {
            Tourist tourist = service.findToursitByid(id);
            return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
        }catch (TouristNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> UpdateTourist(@PathVariable("id") Long id,@RequestBody Tourist tourist){

        try {
            String msg = service.updateTouristrecord(id,tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }catch (TouristNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateTourist2(@RequestBody Tourist tourist){

        try {
            String msg = service.updateTouristrecord2(tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }catch (TouristNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



}
