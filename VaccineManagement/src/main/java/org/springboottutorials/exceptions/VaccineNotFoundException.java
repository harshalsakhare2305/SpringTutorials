package org.springboottutorials.exceptions;

public class VaccineNotFoundException extends Exception{

    private  String message;


    public VaccineNotFoundException(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
