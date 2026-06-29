package org.RestTouristManagement.web;


import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.Tourist;
import org.RestTouristManagement.services.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getTouristById(@PathVariable("id") Long id) throws TouristNotFoundException {


            Tourist tourist = service.findToursitByid(id);
            return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> UpdateTourist(@PathVariable("id") Long id,@RequestBody Tourist tourist) throws TouristNotFoundException {


            String msg = service.updateTouristrecord(id,tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateTourist2(@RequestBody Tourist tourist) throws TouristNotFoundException {


            String msg = service.updateTouristrecord2(tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);

    }

    @PatchMapping("/update/{id}/{newbudget}")
    public ResponseEntity<String> updateTouristBudget(@PathVariable("id") Long id,@PathVariable("newbudget") Long newbudget) throws TouristNotFoundException {


            String status=service.updateTouristBudget(id,newbudget);
            return new ResponseEntity<String>(status,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTouristRecord(@PathVariable("id") Long id) throws TouristNotFoundException {


          String status = service.deleteTourist(id);
          return new ResponseEntity<String>(status,HttpStatus.OK);

    }





}
