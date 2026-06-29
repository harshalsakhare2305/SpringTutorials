package org.RestTouristManagement;

import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristControllerAdvice {


    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleTouristNotFoundException(TouristNotFoundException e){
        ErrorDetail errordetail = new ErrorDetail(e.getMessage(), "404 Not Found", LocalDateTime.now());
        return new ResponseEntity<ErrorDetail>(errordetail, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleException(Exception e){
        ErrorDetail errorDetail = new ErrorDetail(e.getMessage(),"Internal Server Error",LocalDateTime.now());
        return new ResponseEntity<ErrorDetail>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
