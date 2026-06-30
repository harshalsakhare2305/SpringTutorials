package org.ticketbookingapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.ticketbookingapi.exceptions.PassengerNotFoundException;
import org.ticketbookingapi.exceptions.TicketNotFoundException;
import org.ticketbookingapi.model.ErrorDetails;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TicketControllerAdvice {

   @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTicketNotFoundException(TicketNotFoundException e){
        ErrorDetails errorDetails = new ErrorDetails(e.getMsg(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PassengerNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePassengerNotFoundException(PassengerNotFoundException e){
       ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),LocalDateTime.now());

       return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e){
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),LocalDateTime.now());

        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
    }

}
